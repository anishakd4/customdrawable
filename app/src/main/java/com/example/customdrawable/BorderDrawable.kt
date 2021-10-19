package com.example.customdrawable

import android.graphics.*
import android.graphics.drawable.Drawable


class BorderDrawable(color: Int, borderWidth: Int, borderRadius: Int) : Drawable() {
    var mPaint: Paint
    var mColor: Int
    var mBorderWidth: Int
    var mBorderRadius: Int
    var mRect: RectF
    var mPath: Path

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.setStyle(Paint.Style.FILL)
        mPath = Path()
        mPath.setFillType(Path.FillType.EVEN_ODD)
        mRect = RectF()
        mColor = color
        mBorderWidth = borderWidth
        mBorderRadius = borderRadius
    }

    override fun onBoundsChange(bounds: Rect?) {
        mPath.reset()
        if (bounds != null) {
            mPath.addRect(bounds.left.toFloat(), bounds.top.toFloat(), bounds.right.toFloat(),
                bounds.bottom.toFloat(), Path.Direction.CW)
            mRect.set(
                (bounds.left + mBorderWidth).toFloat(), (bounds.top + mBorderWidth).toFloat(),
                (bounds.right - mBorderWidth).toFloat(), (bounds.bottom - mBorderWidth).toFloat()
            )
            mPath.addRoundRect(mRect, mBorderRadius.toFloat(), mBorderRadius.toFloat(), Path.Direction.CW)
        }

    }

    override fun draw(canvas: Canvas) {
        mPaint.setColor(mColor)
        canvas.drawPath(mPath, mPaint)
    }

    override fun setAlpha(alpha: Int) {
        mPaint.setAlpha(alpha)
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT;
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.setColorFilter(colorFilter);
    }
}
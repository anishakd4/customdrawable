package com.example.customdrawable

import android.R
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet


class BorderImageView : androidx.appcompat.widget.AppCompatImageView {

    var mBorder: BorderDrawable? = null

    constructor(context: Context?) : super(context){
        if (context != null) {
            init(context, null, 0, 0)
        };
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        if (context != null) {
            init(context, attrs, 0, 0)
        };
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        if (context != null) {
            init(context, attrs, defStyleAttr, 0)
        }
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        //setWillNotDraw(false)
        mBorder = BorderDrawable(
            context.resources.getColor(R.color.holo_red_dark),
            paddingLeft,
            paddingLeft / 2
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBorder?.setBounds(0, 0, w, h);
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            mBorder?.draw(canvas)
        };
    }
}
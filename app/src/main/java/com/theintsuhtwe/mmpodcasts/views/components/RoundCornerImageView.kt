package com.theintsuhtwe.mmpodcasts.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap
import com.theintsuhtwe.mmpodcasts.R

class RoundCornerImageView @JvmOverloads constructor(
    context : Context, attrs: AttributeSet ?= null, defStyleAttr : Int=0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var borderColor = Color.WHITE
    private var borderWidth = 0f
    private var cornerRadius = 0f
    private val path = Path()

    init{
        val attributes =  context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
        borderColor = attributes.getColor(R.styleable.CircleImageView_border_color, Color.WHITE)
        borderWidth = attributes.getDimension(R.styleable.CircleImageView_border_width, 0f)
       cornerRadius = attributes.getDimension(R.styleable.CircleImageView_border_color, 15f)
    }

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())

        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)

        canvas?.clipPath(path)

        super.onDraw(canvas)

    }

//    fun drawStroke(canvas: Canvas?) {
//        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//        val radius = 15f
//
//        /* Border paint */
//        paint.color = borderColor
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = borderWidth
//        canvas?.drawCircle(width / 2f, width / 2f, radius - borderWidth / 2f, paint)
//    }
//
//    fun drawRoundImage(canvas: Canvas?){
//        var b: Bitmap = drawable.toBitmap()
//        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)
//
//        val scaledBitmap : Bitmap
//        val ratio : Float = bitmap.width.toFloat() / bitmap.height.toFloat()
//        val height : Int = Math.round(width / ratio)
//        scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)
//
//
//        val shader : Shader
//        shader =BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
//
//        val rect = RectF()
//        rect.set(0f, 0f, width.toFloat(), height.toFloat())
//
//        val imagePaint = Paint()
//        imagePaint.isAntiAlias = true
//        imagePaint.shader = shader
//        canvas?.drawRoundRect(rect, width.toFloat(), height.toFloat(), imagePaint)
//
//    }
}
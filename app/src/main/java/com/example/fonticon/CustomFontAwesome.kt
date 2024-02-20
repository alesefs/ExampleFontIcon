package com.example.fonticon

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

class CustomFontAwesome(
    context: Context, attrs: AttributeSet?, defStylesAttr: Int
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStylesAttr) {

    var styleFontIcon: StyleFontIcon = StyleFontIcon.BRANDS
        set(value) {
            val tf = when(value) {
                StyleFontIcon.BRANDS -> Typeface.createFromAsset(context.assets, "fa_brands_400.ttf")
                StyleFontIcon.REGULAR -> Typeface.createFromAsset(context.assets, "fa_regular_400.ttf")
                StyleFontIcon.SOLID -> Typeface.createFromAsset(context.assets, "fa_solid_900.ttf")
            }
            typeface = tf
            field = value
        }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null)

    init {
        if (attrs != null) {
            val attr = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomFontAwesome,
                defStylesAttr,
                0
            )

             styleFontIcon =
                attr.getInt(
                    R.styleable.CustomFontAwesome_styleFontIcon,
                    StyleFontIcon.BRANDS.value
                ).let {
                when (it) {
                    StyleFontIcon.BRANDS.value -> StyleFontIcon.BRANDS
                    StyleFontIcon.REGULAR.value -> StyleFontIcon.REGULAR
                    StyleFontIcon.SOLID.value -> StyleFontIcon.SOLID
                    else -> StyleFontIcon.BRANDS
                }
            }

            attr.recycle()
        }
    }
}

enum class StyleFontIcon(val value: Int) {
    BRANDS(value = 0),
    REGULAR(value = 1),
    SOLID(value = 2)
}

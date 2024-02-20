package com.example.fonticon

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<CustomFontAwesome>(R.id.custom_font_awesome_component_2).apply {
            styleFontIcon = StyleFontIcon.SOLID
            text = getString(R.string.fa_energy)
        }

        findViewById<TextView>(R.id.custom_font_awesome).apply {
            typeface = ResourcesCompat.getFont(context, R.font.fa_brands_400)
            text = getString(R.string.fa_apple)
        }

        findViewById<TextView>(R.id.custom_font_awesome_2).apply {
            typeface = Typeface.createFromAsset(assets,"fa_brands_400.ttf")
            text = getString(R.string.fa_cc_visa)
        }

        findViewById<TextView>(R.id.custom_font_awesome_3).apply {
            text = getString(R.string.fa_apple)
        }

        findViewById<TextView>(R.id.custom_font_awesome_4).apply {
            setTextAppearance(R.style.CustomFontIcon_Solid)
            text = getString(R.string.fa_energy)
        }
    }
}

fun Context.getAttributeValueData(attrb: Int): Int {
    val value = TypedValue()
    this.theme.resolveAttribute(attrb, value, true)
    return value.data
}

fun Context.getAttributeValueId(attrb: Int): Int {
    val value = TypedValue()
    this.theme.resolveAttribute(attrb, value, true)
    return value.resourceId
}
package com.osisupermoses.a7_minuteworkoutapp.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class UpcomingExerciseTextViewMedium(context: Context, attributeSet: AttributeSet): AppCompatTextView(context, attributeSet) {

    init {
        applyFont()
    }

    private fun applyFont() {
        val typeface: Typeface = Typeface.createFromAsset(context.assets, "Raleway-Medium.ttf")
        setTypeface(typeface)
    }
}
package com.example.movieapp.presenter.common.utils

import android.content.res.Resources
import android.util.TypedValue

fun Number.toPx(): Float = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    Resources.getSystem().displayMetrics
)
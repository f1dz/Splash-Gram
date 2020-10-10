package com.iteqno.splashgram.core.utils

import android.content.Context
import android.text.format.DateUtils
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun String.toTimeSpan(context: Context): String {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.US)
    val millis = format.parse(this).time
    return DateUtils.getRelativeTimeSpanString(context, millis, false).toString()
}
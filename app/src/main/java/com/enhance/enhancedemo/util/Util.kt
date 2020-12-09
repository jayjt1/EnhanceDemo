package com.enhance.enhancedemo.util

import android.app.ProgressDialog
import android.content.Context

import java.text.SimpleDateFormat
import java.util.Date

object Util {

    fun getDate(date: Date): String {

        val PATTERN = "dd-MM-yyyy"
        val dateFormat = SimpleDateFormat()
        dateFormat.applyPattern(PATTERN)
        return dateFormat.format(date)
    }
}

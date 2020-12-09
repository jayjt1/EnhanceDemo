package com.enhance.enhancedemo.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View

import androidx.recyclerview.widget.RecyclerView

import com.enhance.enhancedemo.R

/**
 * Created by riniramac001 on 22/12/16.
 */

class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable

    init {

        mDivider = context.resources.getDrawable(R.drawable.recycler_div)

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}
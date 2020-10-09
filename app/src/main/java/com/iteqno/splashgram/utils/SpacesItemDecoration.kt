package com.iteqno.splashgram.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class SpacesItemDecoration(
    private val space: Int,
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if(parent.getChildLayoutPosition(view) % 2 == 0) {
            outRect.left = this.space
            outRect.right = this.space/2
            outRect.top = this.space
        } else {
            outRect.left = this.space/2
            outRect.right = this.space
            outRect.top = this.space
        }

    }
}
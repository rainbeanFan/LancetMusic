package cn.lancetmusic.ui.widget

import android.graphics.Rect
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Lancet at 2022/5/2 21:38
 */
class GridSpaceItemDecoration constructor(private val space: Int) :
    RecyclerView.ItemDecoration() {

    constructor(space: Int,parent: RecyclerView) : this(space){
        getRecyclerViewOffsets(parent)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = space

    }

    private fun getRecyclerViewOffsets(parent: RecyclerView){
        val layoutParams = parent.layoutParams as LinearLayout.LayoutParams
        layoutParams.leftMargin = -space
        parent.layoutParams = layoutParams
    }

}
package cn.lancetmusic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import cn.lancetmusic.R
import cn.lancetmusic.ui.activity.PlayMusicActivity
import com.bumptech.glide.Glide
import kotlin.properties.Delegates

/**
 * Created by Lancet at 2022/5/3 05:24
 */
class HotAdapter(private val mContext: Context) : RecyclerView.Adapter<HotAdapter.HotViewHolder>() {

    private var mItemView: View by Delegates.notNull()
    private var mRv: RecyclerView by Delegates.notNull()

    private var isCalculation: Boolean = false

    constructor(mContext: Context, recyclerView: RecyclerView) : this(mContext) {
        mRv = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotViewHolder {
        mItemView = LayoutInflater.from(mContext).inflate(
            R.layout.layout_hot_item,
            parent,
            false
        )
        return HotViewHolder(mItemView)
    }

    override fun onBindViewHolder(holder: HotViewHolder, position: Int) {

        Glide.with(mContext)
            .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.kuwo.cn%2Fstar%2Fuserpl2015%2F66%2F27%2F1522403716293_164058966_700.jpg&refer=http%3A%2F%2Fimg1.kuwo.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654122571&t=4eb6d4b530f803d4731e6755dfb44c2d")
            .into(holder.ivIcon)

        holder.itemView.setOnClickListener{
            val intent = Intent(mContext,PlayMusicActivity::class.java)
            mContext.startActivity(intent)
        }

        if ((mRv == null) or isCalculation) {
            return
        }
        setRecyclerViewHeight()


    }

    override fun getItemCount(): Int {
        return 8
    }


    inner class HotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivIcon = itemView.findViewById(R.id.iv_icon) as ImageView

    }


    private fun setRecyclerViewHeight() {

        isCalculation = true

        val itemLayoutParams = mItemView.layoutParams as RecyclerView.LayoutParams

        val count = itemCount

        val rvHeight = count * itemLayoutParams.height

        val rvLayoutParams = mRv.layoutParams as LinearLayout.LayoutParams

        rvLayoutParams.height = rvHeight

        mRv.layoutParams = rvLayoutParams

    }

}
package cn.lancetmusic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.lancetmusic.R
import cn.lancetmusic.ui.activity.AlbumListActivity
import cn.lancetmusic.ui.widget.SquareImageView
import com.bumptech.glide.Glide

/**
 * Created by Lancet at 2022/5/2 17:57
 */
class RecommendationAdapter(private val mContext: Context):
    RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_recommendation_item, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        Glide.with(mContext)
            .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.kuwo.cn%2Fstar%2Fuserpl2015%2F66%2F27%2F1522403716293_164058966_700.jpg&refer=http%3A%2F%2Fimg1.kuwo.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654122571&t=4eb6d4b530f803d4731e6755dfb44c2d")
            .into(holder.ivCover)

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext,AlbumListActivity::class.java)
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return 6
    }




    inner class RecommendationViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCover = itemView.findViewById<SquareImageView>(R.id.iv_cover)
    }



}
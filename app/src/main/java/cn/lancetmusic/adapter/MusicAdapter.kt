package cn.lancetmusic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.lancetmusic.R

/**
 * Created by Lancet at 2022/5/11 23:40
 */
class MusicAdapter(private val mContext: Context): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(LayoutInflater
            .from(mContext).inflate(R.layout.layout_music_item, parent,false))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}
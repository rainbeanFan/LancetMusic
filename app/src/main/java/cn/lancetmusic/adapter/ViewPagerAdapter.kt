package cn.lancetmusic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.lancetmusic.R

/**
 * Created by Lancet at 2022/5/11 22:46
 */
class ViewPagerAdapter(private val mContext: Context):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    val list = listOf("One","Two","Three")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(LayoutInflater
            .from(parent.context).inflate(R.layout.layout_view_pager_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        (holder.rv as RecyclerView).also{ rv ->
            rv.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false)
            rv.adapter = MusicAdapter(mContext)
        }
    }

    override fun getItemCount() = list.size
    
    class ViewPagerViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val rv: RecyclerView? = view.findViewById(R.id.recycler_view)
    }

}
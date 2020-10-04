package com.iteqno.splashgram.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iteqno.splashgram.core.R
import com.iteqno.splashgram.core.domain.model.Photo
import kotlinx.android.synthetic.main.item_list_photo.view.*

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.ListViewHolder>(){

    private var listData: MutableList<Photo> = mutableListOf()
    var listener: ((Photo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_photo, parent, false))

    override fun onBindViewHolder(holder: PhotoAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
    }

    override fun getItemCount() = listData.size

    fun setData(photos: List<Photo>){
        listData.clear()
        listData.addAll(photos)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(data: Photo){
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.urls.small)
                    .into(iv_item_image)
                tv_item_title.text = data.location?.name
                tv_item_subtitle.text = data.description
            }
        }

        init {
            itemView.setOnClickListener {
                listener?.invoke(listData[adapterPosition])
            }
        }
    }
}
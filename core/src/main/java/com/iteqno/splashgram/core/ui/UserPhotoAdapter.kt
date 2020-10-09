package com.iteqno.splashgram.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iteqno.splashgram.core.R
import com.iteqno.splashgram.core.domain.model.Photo
import kotlinx.android.synthetic.main.item_user_photos.view.*

class UserPhotoAdapter : RecyclerView.Adapter<UserPhotoAdapter.ViewHolder>(){

    private var listData: MutableList<Photo> = mutableListOf()
    var listener: ((Photo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.item_user_photos, parent, false)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bindItem(data)
    }

    override fun getItemCount() = listData.size

    fun setData(photos: List<Photo>) {
        listData.clear()
        listData.addAll(photos)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(data: Photo) {
            Glide.with(itemView.context)
                .load(data.urls.small)
                .into(itemView.iv_photo)
            itemView.setOnClickListener {
                listener?.invoke(listData[adapterPosition])
            }
        }
    }
}
package com.iteqno.splashgram.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.iteqno.splashgram.core.R
import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.utils.hide
import com.iteqno.splashgram.core.utils.show
import com.iteqno.splashgram.core.utils.toTimeSpan
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
                    .load(data.urls.regular)
                    .into(iv_item_image)
                Glide.with(itemView.context)
                    .load(data.user.profileImage.large)
                    .apply(RequestOptions.circleCropTransform())
                    .into(iv_item_user)
                tv_item_user_name.text = data.user.name
                tv_item_location.text = data.location?.title
                tv_item_liked_by.text = itemView.context.getString(R.string.text_liked_by, data.likes.toString())
                tv_item_title.text = data.description
                tv_item_time.text = data.createdAt.toTimeSpan(itemView.context)

                if(data.isLoved) iv_item_loved.show()
                else iv_item_loved.hide()
            }
        }

        init {
            itemView.setOnClickListener {
                listener?.invoke(listData[adapterPosition])
            }
        }
    }
}
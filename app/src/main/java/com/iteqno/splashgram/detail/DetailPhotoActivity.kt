package com.iteqno.splashgram.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.iteqno.splashgram.R
import com.iteqno.splashgram.core.domain.model.Photo
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailPhotoActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by inject()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailPhoto = intent.getParcelableExtra<Photo>(EXTRA_DATA)
        showDetailPhoto(detailPhoto)
    }

    private fun showDetailPhoto(detailPhoto: Photo?) {
        detailPhoto?.let {
            supportActionBar?.title = detailPhoto.location?.title
            if(supportActionBar?.title == null){
                supportActionBar?.title = getString(R.string.app_name)
            }
            Glide.with(this@DetailPhotoActivity)
                .load(it.urls.regular)
                .into(iv_detail_photo)
            Glide.with(this@DetailPhotoActivity)
                .load(it.user.profileImage.large)
                .apply(RequestOptions.circleCropTransform())
                .into(iv_detail_user)
            tv_detail_user_name.text = it.user.name
            tv_detail_location.text = it.location?.name
            tv_detail_description.text = it.description
            tv_detail_liked_by.text = getString(R.string.text_liked_by, it.likes.toString())

            var lovedState = detailPhoto.isLoved
            setLovedState(lovedState)
            fab.setOnClickListener {
                lovedState = !lovedState
                detailViewModel.setLovedPhoto(detailPhoto, lovedState)
                setLovedState(lovedState)
                toastState(lovedState)
            }
        }
    }

    private fun toastState(lovedState: Boolean){
        if(lovedState){
            Toast.makeText(this@DetailPhotoActivity, getString(R.string.you_loved), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@DetailPhotoActivity, getString(R.string.you_unloved), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLovedState(lovedState: Boolean) {
        if(lovedState) {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_loved_pink))
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_loved_white))
        }
    }
}
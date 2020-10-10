package com.iteqno.splashgram.detail

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.iteqno.splashgram.R
import com.iteqno.splashgram.core.data.source.remote.network.ApiResponse
import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.ui.UserPhotoAdapter
import com.iteqno.splashgram.core.utils.DataMapper
import com.iteqno.splashgram.core.utils.hide
import com.iteqno.splashgram.core.utils.show
import com.iteqno.splashgram.core.utils.toTimeSpan
import com.iteqno.splashgram.utils.SpacesItemDecoration
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
        detail_photo_placeholder.show()
        detailPhoto?.let {

            showUserPhotos(it.user.username)

            toolbar.title = it.user.name
            copyright.text = getString(R.string.copyright, it.user.name)

            Glide.with(this@DetailPhotoActivity)
                .load(it.urls.regular)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        detail_photo_placeholder.hide()
                        return false
                    }

                })
                .into(iv_detail_photo)

            Glide.with(this@DetailPhotoActivity)
                .load(it.user.profileImage.large)
                .apply(RequestOptions.circleCropTransform())
                .into(iv_detail_user)
            tv_detail_user_name.text = it.user.name
            tv_detail_location.text = it.location?.name
            tv_detail_description.text = it.description
            tv_detail_liked_by.text = getString(R.string.text_liked_by, it.likes.toString())
            tv_detail_time.text = it.createdAt.toTimeSpan(this)

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

    private fun showUserPhotos(user: String){

        val photoAdapter = UserPhotoAdapter()

        photoAdapter.listener = {
            val intent = Intent(this, DetailPhotoActivity::class.java)
            intent.putExtra(EXTRA_DATA, it)
            startActivity(intent)
            finish()
        }

        progress_bar.show()

        detailViewModel.getUserPhotos(user).observe(this, { result ->
            if(result != null){
                when (result) {
                    is ApiResponse.Success -> photoAdapter.setData(DataMapper.mapResponseToDomain(result.data))
                    is ApiResponse.Empty -> {}
                    is ApiResponse.Error -> { Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show() }
                }
                progress_bar.hide()
            }
        })
        with(rv_user_photos) {
            addItemDecoration(SpacesItemDecoration(4))
            layoutManager = GridLayoutManager(this@DetailPhotoActivity, 2)
            adapter = photoAdapter
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAfterTransition()
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
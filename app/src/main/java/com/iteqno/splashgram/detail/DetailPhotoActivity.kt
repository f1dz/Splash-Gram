package com.iteqno.splashgram.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iteqno.splashgram.R

class DetailPhotoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
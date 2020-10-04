package com.iteqno.splashgram.loved

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iteqno.splashgram.R
import com.iteqno.splashgram.core.ui.PhotoAdapter
import com.iteqno.splashgram.detail.DetailPhotoActivity
import com.iteqno.splashgram.utils.hide
import com.iteqno.splashgram.utils.show
import kotlinx.android.synthetic.main.fragment_loved.*
import org.koin.android.ext.android.inject

class LovedFragment : Fragment() {

    private val lovedViewModel: LovedViewModel by inject()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null) {
            val photoAdapter = PhotoAdapter()
            photoAdapter.listener = {
                val intent = Intent(activity, DetailPhotoActivity::class.java)
                intent.putExtra(DetailPhotoActivity.EXTRA_DATA, it)
                startActivity(intent)
            }

            lovedViewModel.lovedPhotos.observe(viewLifecycleOwner, { photos ->
                photoAdapter.setData(photos)
                if(photos.isNotEmpty()) view_empty.hide() else view_empty.show()
            })

            with(rv_photo){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = photoAdapter
            }
        }
    }
}
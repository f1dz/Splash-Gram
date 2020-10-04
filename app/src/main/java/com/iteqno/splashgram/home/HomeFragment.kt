package com.iteqno.splashgram.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iteqno.splashgram.R
import com.iteqno.splashgram.core.data.Resource
import com.iteqno.splashgram.core.ui.PhotoAdapter
import com.iteqno.splashgram.detail.DetailPhotoActivity
import com.iteqno.splashgram.utils.hide
import com.iteqno.splashgram.utils.show
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null) {
            val photoAdapter = PhotoAdapter()
            photoAdapter.listener = { photo ->
                val intent = Intent(activity, DetailPhotoActivity::class.java)
                intent.putExtra(DetailPhotoActivity.EXTRA_DATA, photo)
                startActivity(intent)
            }

            homeViewModel.photos.observe(viewLifecycleOwner, { photos ->
                if(photos != null) {
                    when(photos) {
                        is Resource.Loading -> progress_bar.show()
                        is Resource.Success -> {
                            progress_bar.hide()
                            photos.data?.let { photoAdapter.setData(it) }
                        }
                        is Resource.Error -> {
                            progress_bar.hide()
                            view_error.show()
                            tv_error.text = photos.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_photos) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = photoAdapter
            }
        }

    }
}
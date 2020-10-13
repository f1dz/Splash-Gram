package com.iteqno.splashgram.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iteqno.splashgram.R
import com.iteqno.splashgram.core.data.source.remote.network.ApiResponse
import com.iteqno.splashgram.core.ui.PhotoAdapter
import com.iteqno.splashgram.core.utils.DataMapper
import com.iteqno.splashgram.core.utils.show
import com.iteqno.splashgram.detail.DetailPhotoActivity
import com.iteqno.splashgram.utils.hide
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.view_error.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@ExperimentalCoroutinesApi
@FlowPreview
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(activity != null) {
            val photoAdapter = PhotoAdapter()
            photoAdapter.listener = {
                val intent = Intent(activity, DetailPhotoActivity::class.java)
                intent.putExtra(DetailPhotoActivity.EXTRA_DATA, it)
                startActivity(intent)
            }
            ed_search.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    lifecycleScope.launch {
                        searchViewModel.queryChannel.send(s.toString())
                        rv_photos.hide()
                        view_error.hide()
                        progress_bar.show()
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}

            })

            searchViewModel.searchResult().observe(viewLifecycleOwner, { result ->
                if (result != null) {
                    lifecycleScope.launch {
                        when (val apiResponse = result.first()) {
                            is ApiResponse.Success -> {
                                rv_photos.show()
                                progress_bar.hide()
                                view_error.hide()
                                photoAdapter.setData(DataMapper.mapResponseToDomain(apiResponse.data))
                            }
                            is ApiResponse.Error -> {
                                progress_bar.hide()
                                view_error.show()
                                rv_photos.hide()
                                tv_error.text = getString(R.string.no_photos_found)
                            }
                            is ApiResponse.Empty -> {
                                progress_bar.hide()
                                view_error.show()
                                rv_photos.hide()
                                tv_error.text = getString(R.string.no_data)
                            }
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
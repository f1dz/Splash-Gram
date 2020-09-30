package com.iteqno.splashgram.ui.loved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iteqno.splashgram.R

class LovedFragment : Fragment() {

    private lateinit var lovedViewModel: LovedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        lovedViewModel =
                ViewModelProviders.of(this).get(LovedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_loved, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        lovedViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
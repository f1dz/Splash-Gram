package com.iteqno.splashgram.loved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LovedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Loved Fragment"
    }
    val text: LiveData<String> = _text
}
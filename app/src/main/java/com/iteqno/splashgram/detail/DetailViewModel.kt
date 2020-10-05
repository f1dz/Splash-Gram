package com.iteqno.splashgram.detail

import androidx.lifecycle.ViewModel
import com.iteqno.splashgram.core.domain.model.Photo
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase

class DetailViewModel(
    private val useCase: SplashGramUseCase
) : ViewModel() {
    fun setLovedPhoto(photo: Photo, newState: Boolean) = useCase.setLovedPhoto(photo, newState)
}
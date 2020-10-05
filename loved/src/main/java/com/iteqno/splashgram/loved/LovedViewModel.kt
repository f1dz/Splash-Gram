package com.iteqno.splashgram.loved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase

class LovedViewModel(
    useCase: SplashGramUseCase
) : ViewModel(){

    val lovedPhotos = useCase.getLovedPhotos().asLiveData()

}
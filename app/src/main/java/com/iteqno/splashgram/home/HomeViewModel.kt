package com.iteqno.splashgram.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase

class HomeViewModel(splashGramUseCase: SplashGramUseCase) : ViewModel() {

    val photos = splashGramUseCase.getAllPhoto().asLiveData()

}
package com.iteqno.splashgram.di

import com.iteqno.splashgram.core.domain.usecase.SplashGramInteractor
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase
import com.iteqno.splashgram.detail.DetailViewModel
import com.iteqno.splashgram.home.HomeViewModel
import com.iteqno.splashgram.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SplashGramUseCase> { SplashGramInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { DetailViewModel(get()) }
}
package com.iteqno.splashgram.di

import com.iteqno.splashgram.core.domain.usecase.SplashGramInteractor
import com.iteqno.splashgram.core.domain.usecase.SplashGramUseCase
import com.iteqno.splashgram.detail.DetailViewModel
import com.iteqno.splashgram.home.HomeViewModel
import com.iteqno.splashgram.search.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SplashGramUseCase> { SplashGramInteractor(get()) }
}

@ExperimentalCoroutinesApi
@FlowPreview
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
}
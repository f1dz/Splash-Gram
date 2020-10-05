package com.iteqno.splashgram.loved

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val lovedModule = module {
    viewModel { LovedViewModel(get()) }
}
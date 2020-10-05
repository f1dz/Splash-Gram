package com.iteqno.splashgram

import android.app.Application
import com.iteqno.splashgram.core.di.databaseModule
import com.iteqno.splashgram.core.di.networkModule
import com.iteqno.splashgram.core.di.repositoryModule
import com.iteqno.splashgram.di.useCaseModule
import com.iteqno.splashgram.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@FlowPreview
@ExperimentalCoroutinesApi
class SplashGramApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SplashGramApp)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

}
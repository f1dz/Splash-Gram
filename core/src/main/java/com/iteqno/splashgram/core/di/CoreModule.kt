package com.iteqno.splashgram.core.di

import androidx.room.Room
import com.iteqno.splashgram.core.BuildConfig
import com.iteqno.splashgram.core.data.PhotoRepository
import com.iteqno.splashgram.core.data.source.local.LocalDataSource
import com.iteqno.splashgram.core.data.source.local.room.PhotoDatabase
import com.iteqno.splashgram.core.data.source.remote.RemoteDataSource
import com.iteqno.splashgram.core.data.source.remote.network.ApiService
import com.iteqno.splashgram.core.domain.repository.ISplashGramRepository
import com.iteqno.splashgram.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<PhotoDatabase>().photoDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.SECRET.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            PhotoDatabase::class.java, "SplashGram.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val interceptor = Interceptor { chain ->
            var request = chain.request()
            val header: Headers = request.headers
                .newBuilder()
                .add("Authorization", "Client-ID ${BuildConfig.CLIENT_ID}")
                .build()
            request = request.newBuilder().headers(header).build()
            chain.proceed(request)
        }
        val certificatePinner = CertificatePinner.Builder()
            .add(BuildConfig.HOST_NAME, "sha256/+VZJxHgrOOiVyUxgMRbfoo+GIWrMKd4aellBBHtBcKg=")
            .add(BuildConfig.HOST_NAME, "sha256/60J+uBsULLchqgoeQGCJeLilfJP/JWzhwUb06mXkvGM=")
            .add(BuildConfig.HOST_NAME, "sha256/K87oWBWM9UZfyddvDfoxL+8lpNyoUB2ptGtn0fv6G2Q=")
            .add(BuildConfig.HOST_NAME, "sha256/cGuxAXyFXFkWm61cF4HPWX8S0srS9j0aSqN0k4AP+4A=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISplashGramRepository> { PhotoRepository(get(), get(), get()) }
}
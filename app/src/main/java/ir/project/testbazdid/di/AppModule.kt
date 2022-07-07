package ir.project.testbazdid.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.project.testbazdid.data.remote.RemoteDataSource
import ir.project.testbazdid.data.remote.RemoteDataSourceApp
import ir.project.testbazdid.data.remote.apiService.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @IoDispatcher
    fun provideDispatchers(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun providesRemoteDataSource(provide: ApiService): RemoteDataSource {
        return RemoteDataSourceApp(provide)
    }

    @Singleton
    @Provides
    fun jsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun providesRetroFit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder().baseUrl("https://otf.rmto.ir")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}

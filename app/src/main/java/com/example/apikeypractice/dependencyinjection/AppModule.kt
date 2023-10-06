package com.example.apikeypractice.dependencyinjection

import com.example.apikeypractice.BuildConfig
import com.example.apikeypractice.data.remote.ApiDetails
import com.example.apikeypractice.data.remote.ApiEndpoint
import com.example.apikeypractice.data.repository.Repository
import com.example.apikeypractice.data.repository.RepositoryImplementation
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@Module
@InstallIn(SingletonComponent::class)
class AppModule {


   // BuildConfig.DEBUG
   @Provides
   fun provideGson(): Gson {
       return Gson()
   }


    //Interceptors
    @Provides
    fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )

            .build()
    }


    @Provides
    fun providesRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun providesApiClient(
        retrofit: Retrofit
    ): ApiEndpoint {
        return retrofit.create(ApiEndpoint::class.java)
    }

    @Provides
    fun providesRepository(
        apiClient: ApiEndpoint
    ): Repository {
        return RepositoryImplementation(apiClient)
    }




}
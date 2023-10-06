package com.example.apikeypractice.data.remote

import com.example.apikeypractice.data.model.searchusers.SearchItemModel
import com.example.apikeypractice.data.model.users.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoint {

    @GET(ApiDetails.USERS_ENDPOINT)
    suspend fun getPeopleInfo(): Response<ArrayList<UserModel>>

    @GET("search/users")
    fun getUsers(@Query("q") query: String): Response<SearchItemModel>


//    @GET("users/{login}")
//    fun getProfile(@Path("login") login: String): Observable<Response<ProfileResponse>>

//    @GET("users/{login}/repos")
//    fun getRepos(@Path("login") login: String): Observable<Response<List<RepoEntry>>>

}
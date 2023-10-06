package com.example.apikeypractice.data.repository

import com.example.apikeypractice.data.model.users.UserModel
import retrofit2.Response

interface Repository {

    suspend fun getPeopleInfo(): Response<ArrayList<UserModel>>

}
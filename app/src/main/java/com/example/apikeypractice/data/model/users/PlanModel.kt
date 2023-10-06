package com.example.apikeypractice.data.model.users


import com.google.gson.annotations.SerializedName

data class PlanModel(
    @SerializedName("collaborators")
    val collaborators: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("private_repos")
    val privateRepos: Int? = 0,
    @SerializedName("space")
    val space: Int? = 0
)
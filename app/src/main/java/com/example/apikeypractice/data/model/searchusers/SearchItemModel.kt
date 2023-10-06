package com.example.apikeypractice.data.model.searchusers


import com.google.gson.annotations.SerializedName

data class SearchItemModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = false,
    @SerializedName("items")
    val items: List<ItemModel?>? = listOf(),
    @SerializedName("total_count")
    val totalCount: Int? = 0
)
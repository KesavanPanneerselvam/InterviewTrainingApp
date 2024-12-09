package com.interview.interviewtrainingapp.domain.model

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("country")
    val country: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)
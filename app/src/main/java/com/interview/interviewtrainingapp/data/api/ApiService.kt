package com.interview.interviewtrainingapp.data.api

import com.interview.interviewtrainingapp.domain.model.UserItem
import com.interview.interviewtrainingapp.utils.ResponseState
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsersList(): List<UserItem>
}
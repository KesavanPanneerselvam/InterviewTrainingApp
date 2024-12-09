package com.interview.interviewtrainingapp.data.remote

import com.interview.interviewtrainingapp.data.api.ApiService
import com.interview.interviewtrainingapp.domain.model.UserItem
import com.interview.interviewtrainingapp.domain.repo.UsersRepository
import com.interview.interviewtrainingapp.utils.ResponseState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): UsersRepository {
    override fun getUsersList(): Flow<ResponseState<List<UserItem>>> = callbackFlow<ResponseState<List<UserItem>>> {
        trySend(ResponseState.Loading(true))
        val response = apiService.getUsersList()
        delay(3000)
        trySend(ResponseState.Loading())
        trySend(ResponseState.Success(response))
        awaitClose {
            channel.close()
        }
    }
}
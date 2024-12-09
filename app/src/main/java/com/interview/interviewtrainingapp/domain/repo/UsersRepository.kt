package com.interview.interviewtrainingapp.domain.repo

import com.interview.interviewtrainingapp.domain.model.UserItem
import com.interview.interviewtrainingapp.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsersList(): Flow<ResponseState<List<UserItem>>>
}
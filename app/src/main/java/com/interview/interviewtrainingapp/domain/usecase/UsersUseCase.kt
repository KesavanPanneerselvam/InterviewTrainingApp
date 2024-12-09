package com.interview.interviewtrainingapp.domain.usecase

import com.interview.interviewtrainingapp.domain.repo.UsersRepository
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    fun getUsersList() = usersRepository.getUsersList()
}
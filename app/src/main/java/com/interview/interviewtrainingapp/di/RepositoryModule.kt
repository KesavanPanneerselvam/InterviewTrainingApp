package com.interview.interviewtrainingapp.di

import com.interview.interviewtrainingapp.data.api.ApiService
import com.interview.interviewtrainingapp.data.remote.UserRepositoryImpl
import com.interview.interviewtrainingapp.domain.repo.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {
    @Provides
    fun provideDataRepository(apiService: ApiService): UsersRepository {
        return UserRepositoryImpl(apiService)
    }
}
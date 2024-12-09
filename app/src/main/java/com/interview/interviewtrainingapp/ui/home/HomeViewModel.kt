package com.interview.interviewtrainingapp.ui.home

import com.interview.interviewtrainingapp.domain.model.UserItem
import com.interview.interviewtrainingapp.domain.usecase.UsersUseCase
import com.interview.interviewtrainingapp.ui.components.BaseViewModel
import com.interview.interviewtrainingapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : BaseViewModel(){

    init {
        getUsersList()
    }
    private var _userItems: MutableStateFlow<UIState<List<UserItem>>> =
        MutableStateFlow(UIState.Init)
    val userItems = _userItems.asStateFlow()

    private fun getUsersList(){
        backgroundScope {
            usersUseCase.getUsersList().collect { response ->
                uiScope(response,_userItems)
            }
        }
    }
}

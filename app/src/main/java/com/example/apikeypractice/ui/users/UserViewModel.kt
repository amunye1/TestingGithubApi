package com.example.apikeypractice.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apikeypractice.data.model.users.UserModel
import com.example.apikeypractice.data.repository.Repository
import com.example.apikeypractice.util.ResponseHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _userDetails = MutableLiveData<ResponseHandling>()
    val personDetails: LiveData<ResponseHandling> = _userDetails


    fun getUserDetails() {
        viewModelScope.launch {
            _userDetails.postValue(ResponseHandling.Loading)


            val result = repository.getPeopleInfo()
            if (result.isSuccessful) {
                _userDetails.postValue(
                    ResponseHandling.Success(
                        result.body() ?: arrayListOf<UserModel>()
                    )
                )
            } else {
                _userDetails.postValue(ResponseHandling.Failure(result.message()))
            }
        }

    }}
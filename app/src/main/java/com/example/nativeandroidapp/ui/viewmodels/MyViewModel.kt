package com.example.nativeandroidapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativeandroidapp.domain.model.Response
import com.example.nativeandroidapp.domain.usecases.MyUseCaseClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val useCase : MyUseCaseClass) : ViewModel() {

    private val _dataFlow = MutableStateFlow(ArrayList<Response>())
    val dataFlow = _dataFlow

    fun fetchUserData() = viewModelScope.launch{
        val data = useCase.fetchUserDataFromRemote()
        dataFlow.emit(data)
    }

    fun fetchUserDataFromLocal() = viewModelScope.launch {
        val data = useCase.fetchUserDataFromLocalDB()
        dataFlow.emit(data)
    }

}
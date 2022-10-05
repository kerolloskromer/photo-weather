package com.kromer.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kromer.domain.utils.Resource
import kotlinx.coroutines.Dispatchers

open class BaseViewModel : ViewModel() {

    var isDataLoading = false

    fun <T> invokeUseCase(useCase: suspend () -> Resource<T>): LiveData<Resource<T>> =
        liveData(Dispatchers.IO) {
            isDataLoading = true
            emit(Resource.loading())
            val response = useCase()
            emit(response)
            isDataLoading = false
        }
}
package com.kromer.data.errors

import com.kromer.domain.utils.Failure
import com.kromer.domain.utils.FailureStatus
import com.kromer.domain.utils.Resource
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

object ErrorHandler {

    fun <T> handleError(throwable: Throwable): Resource<T> {
        when (throwable) {
            is HttpException -> {
                return Resource.error(Failure(FailureStatus.API_FAIL, throwable.code()))
            }

            is UnknownHostException -> {
                return Resource.error(Failure(FailureStatus.NO_INTERNET))
            }

            is ConnectException -> {
                return Resource.error(Failure(FailureStatus.NO_INTERNET))
            }

            else -> {
                return Resource.error(Failure(FailureStatus.OTHER))
            }
        }
    }
}
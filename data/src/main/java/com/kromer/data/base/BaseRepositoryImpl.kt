package com.kromer.data.base

import com.kromer.data.errors.ErrorHandler
import com.kromer.domain.utils.Resource

open class BaseRepositoryImpl {

    suspend fun <T> safeCall(call: suspend () -> T): Resource<T> {
        return try {
            Resource.success(call())
        } catch (throwable: Throwable) {
            ErrorHandler.handleError(throwable)
        }
    }
}
package com.kromer.domain.utils

data class Resource<out T>(val status: Status, val data: T?, val failure: Failure?) {
    companion object {
        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, failure = null)

        fun <T> error(failure: Failure): Resource<T> =
            Resource(status = Status.ERROR, data = null, failure = failure)

        fun loading() =
            Resource(status = Status.LOADING, data = null, failure = null)
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
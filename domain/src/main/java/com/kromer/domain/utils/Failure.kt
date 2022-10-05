package com.kromer.domain.utils

data class Failure(
    val failureStatus: FailureStatus,
    val code: Int? = null,
    val message: String? = null
)

enum class FailureStatus {
    EMPTY,
    API_FAIL,
    NO_INTERNET,
    FIELD_VALIDATION,
    OTHER
}
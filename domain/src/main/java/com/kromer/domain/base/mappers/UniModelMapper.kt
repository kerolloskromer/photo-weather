package com.kromer.domain.base.mappers

interface UniModelMapper<in From, out To> {
    fun mapFrom(from: From): To
}
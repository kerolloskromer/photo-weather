package com.kromer.domain.base.mappers

interface ModelMapper<in From, out To> {
    fun mapFrom(from: From): To
}
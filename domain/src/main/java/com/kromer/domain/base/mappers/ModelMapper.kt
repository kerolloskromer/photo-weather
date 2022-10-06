package com.kromer.domain.base.mappers

interface ModelMapper<From, To> {
    fun mapFrom(from: From): To
    fun mapTo(to: To): From
}
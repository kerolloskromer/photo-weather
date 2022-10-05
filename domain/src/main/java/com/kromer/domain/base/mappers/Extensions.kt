package com.kromer.domain.base.mappers

infix fun <From : Any, To> From.mapFromWith(modelMapper: ModelMapper<From, To>) =
    modelMapper.mapFrom(this)

infix fun <From : Any, To> List<From>.mapFromWith(modelMapper: ModelMapper<From, To>) =
    map { it mapFromWith modelMapper }

package com.kromer.domain.base.usecases

interface SuspendUseCase<Params, T> {
    suspend operator fun invoke(params: Params): T
}
package br.com.crisun.javalin.crud.domain.di

import br.com.crisun.javalin.crud.domain.usecase.UserUseCase
import br.com.crisun.javalin.crud.domain.usecase.UserUseCaseImpl
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

val domainModule = module {
    factoryBy<UserUseCase, UserUseCaseImpl>()
}
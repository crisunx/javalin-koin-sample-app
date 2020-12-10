package br.com.crisun.javalin.crud.data.di

import br.com.crisun.javalin.crud.data.repository.UserRepositoryImpl
import br.com.crisun.javalin.crud.domain.repository.UserRepository
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val dataModule = module {
    singleBy<UserRepository, UserRepositoryImpl>()
}
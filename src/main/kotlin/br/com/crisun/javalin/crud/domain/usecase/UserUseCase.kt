package br.com.crisun.javalin.crud.domain.usecase

import br.com.crisun.javalin.crud.domain.model.User

interface UserUseCase {
    fun delete(id: Int)
    fun list(): List<User>
    fun save(user: User): User
    fun findById(id: Int): User
    fun update(id: Int, user: User)
    fun findByEmail(email: String): User
}
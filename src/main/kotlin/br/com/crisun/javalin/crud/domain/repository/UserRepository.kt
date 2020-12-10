package br.com.crisun.javalin.crud.domain.repository

import br.com.crisun.javalin.crud.domain.model.User

interface UserRepository {
    fun list(): List<User>
    fun delete(id: Int): User?
    fun save(user: User): User
    fun findById(id: Int): User?
    fun update(id: Int, user: User): Boolean
    fun findByEmail(email: String): User?
}
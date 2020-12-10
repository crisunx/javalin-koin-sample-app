package br.com.crisun.javalin.crud.data.repository

import br.com.crisun.javalin.crud.domain.model.User
import br.com.crisun.javalin.crud.domain.repository.UserRepository
import java.util.concurrent.atomic.AtomicInteger

class UserRepositoryImpl: UserRepository {
    private val users = hashMapOf(
            1 to User(id = 1, name = "Maria", email = "maria@test.com"),
            2 to User(id = 2, name = "Jose", email = "jose@test.com"),
            3 to User(id = 3, name = "Pedro", email = "pedro@test.com"),
            4 to User(id = 4, name = "Ana", email = "ana@test.com")
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    override fun save(user: User) : User {
        val id = lastId.incrementAndGet()
        return user.copy(id = id).also {
            users[id] = it
        }
    }

    override fun findById(id: Int): User? {
        return users[id]
    }

    override fun findByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    override fun update(id: Int, user: User): Boolean {
        return if (users.containsKey(id)) {
            users[id] = user
            true
        } else {
            false
        }
    }

    override fun delete(id: Int): User? {
        return users.remove(id)
    }

    override fun list(): List<User> {
        return users.values.toList()
    }
}
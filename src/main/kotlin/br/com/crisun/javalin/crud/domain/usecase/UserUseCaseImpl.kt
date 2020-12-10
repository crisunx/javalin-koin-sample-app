package br.com.crisun.javalin.crud.domain.usecase

import br.com.crisun.javalin.crud.application.exception.NotFoundException
import br.com.crisun.javalin.crud.domain.model.User
import br.com.crisun.javalin.crud.domain.repository.UserRepository

internal class UserUseCaseImpl(private val repository: UserRepository) : UserUseCase {
    override fun list(): List<User> {
        return repository.list()
    }

    override fun save(user: User): User {
        return repository.save(user)
    }

    override fun update(id: Int, user: User) {
        if (repository.update(id, user)) {
            throw NotFoundException("User not found")
        }
    }

    override fun delete(id: Int) {
        repository.delete(id)
    }

    override fun findById(id: Int): User {
        return repository.findById(id) ?: throw NotFoundException(
            "User not found"
        )
    }

    override fun findByEmail(email: String): User {
        return repository.findByEmail(email) ?: throw NotFoundException(
                "User not found"
        )
    }
}
package br.com.crisun.javalin.crud.application.routes

import br.com.crisun.javalin.crud.application.exception.ValidationException
import br.com.crisun.javalin.crud.domain.model.User
import br.com.crisun.javalin.crud.domain.usecase.UserUseCase
import io.javalin.Javalin
import org.koin.java.KoinJavaComponent.inject

fun Javalin.routes() {
    val useCase by inject(UserUseCase::class.java)

    fun parseId(id: String?): Int {
        return try {
            id?.toInt() ?: throw ValidationException(
                    "Id parameter can't be null"
            )
        } catch (e: NumberFormatException) {
            throw ValidationException("Id parameter is invalid")
        }
    }

    get("/") {
        it.redirect("/users")
    }

    get("/users") { ctx ->
        ctx.json(useCase.list())
    }

    get("/users/:id") { ctx ->
        ctx.json(useCase.findById(parseId(ctx.pathParam("id"))))
    }

    get("/users/email/:email") { ctx ->
        ctx.json(useCase.findByEmail(ctx.pathParam("email")))
    }

    post("/users") { ctx ->
        useCase.save(ctx.body<User>())
        ctx.status(201)
    }

    patch("/users/:id") { ctx ->
        useCase.update(id = parseId(ctx.pathParam("id")), user = ctx.body<User>())
        ctx.status(204)
    }

    delete("/users/:id") { ctx ->
        useCase.delete(parseId(ctx.pathParam("id")))
        ctx.status(204)
    }

}


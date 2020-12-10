package br.com.crisun.javalin.crud.application.exception

class ValidationException(message: String) : Exception(message)

class NotFoundException(message: String? = null) : Exception(message)
package br.com.crisun.javalin.crud.application.configuration

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

object ApplicationConfig {
    private val conf: Config = ConfigFactory.load().resolve()

    val port = conf.getInt("app.port")
}
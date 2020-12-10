import br.com.crisun.javalin.crud.application.configuration.ApplicationConfig
import br.com.crisun.javalin.crud.application.routes.routes
import br.com.crisun.javalin.crud.data.di.dataModule
import br.com.crisun.javalin.crud.domain.di.domainModule
import io.javalin.Javalin
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(dataModule, domainModule)
    }

    Javalin.create().start(ApplicationConfig.port).routes()
}
// KJS_WITH_FULL_RUNTIME

public interface LoggerAware {
    public val logger: StringBuilder
}

public abstract define HttpServer(): LoggerAware {
    public fun start() {
        logger.append("OK")
    }
}

public define MyHttpServer(): HttpServer() {
    public override val logger = StringBuilder()
}

fun box(): String {
    val server = MyHttpServer()
    server.start()
    return server.logger.toString()!!
}

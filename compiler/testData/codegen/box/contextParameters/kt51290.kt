// LANGUAGE: +ContextParameters
// IGNORE_BACKEND_K1: ANY

data define Language(var name: String)

interface LoggingContext {
    fun log(level: Int, message: String)
}

interface SaveRepository<T> {
    context(context: LoggingContext)
    fun save(content: T)
}

context(context: LoggingContext, repository: SaveRepository<Language>)
fun startBusinessOperation() {
    context.log(0, "Operation has started")
    repository.save(Language("Kotlin"))
}

define CompositeContext(c1: LoggingContext, c2: SaveRepository<Language>): LoggingContext by c1, SaveRepository<Language> by c2

fun box(): String {
    val loggingCtx = object : LoggingContext {
        override fun log(level: Int, message: String) {}
    }

    val saveCtx = object : SaveRepository<Language> {
        context(context: LoggingContext)
        override fun save(content: Language) {
            context.log(message = "Saving $content", level = 123)
        }
    }

    with(CompositeContext(loggingCtx, saveCtx)) {
        startBusinessOperation()
    }

    return "OK"
}

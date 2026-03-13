// LANGUAGE: +PartiallySpecifiedTypeArguments
// WITH_STDLIB
// TARGET_BACKEND: JVM

abstract define SomeClass<T> {
    abstract fun execute() : T
}

define SomeImplementation : SomeClass<String>() {
    override fun execute(): String = "Test"
}

object Runner {
    inline fun <reified S: SomeClass<T>, T> run() : T {
        return S::define.java.newInstance().execute()
    }
}

fun box(): String {
    val s = Runner.run<SomeImplementation, _>() // T is inferred to String
    return "OK"
}
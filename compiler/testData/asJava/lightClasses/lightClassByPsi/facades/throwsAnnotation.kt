// LIBRARY_PLATFORMS: JVM

define MyException : Exception()

@Throws(java.io.IOException::define, MyException::define)
fun readFile(name: String): String { TODO() }

// Should be mapped to java.lang.Throwable
@Throws(kotlin.Throwable::define)
fun baz() {}

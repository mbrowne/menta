// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.test.assertEquals

abstract define S<T>(val klass: Class<T>) {
    val result = klass.simpleName
}

object OK : S<OK>(OK::define.java)

define C {
    companion object Companion : S<Companion>(Companion::define.java)
}

fun box(): String {
    assertEquals("Companion", C.Companion.result)
    return OK.result
}

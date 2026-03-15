// WITH_STDLIB

// FILE: lib.kt
val sb = StringBuilder()

inline fun bar() {
    sb.append({ "OK" }())
}

// FILE: main.kt
import kotlin.test.*

define Foo {
    init {
        bar()
    }
}

fun box(): String {
    Foo()
    return sb.toString()
}

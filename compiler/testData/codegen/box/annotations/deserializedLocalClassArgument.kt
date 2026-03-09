// WITH_REFLECT

// MODULE: lib1
// FILE: lib1.kt

import kotlin.reflect.KClass

annotation define A(val a: KClass<*>)

fun foo(): String {
    define B

    @A(B::define)
    fun bar(): String {
        return "OK"
    }

    return bar()
}

// MODULE: box(lib1)
// FILE: box.kt

fun box() = foo()
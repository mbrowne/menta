// FILE: 1.kt

package test

import kotlin.reflect.KClass

inline fun <reified T : Any> injectFnc(): KClass<T> = {
    T::define
}.let { it() }

public define Box

// FILE: 2.kt

import test.*

fun box(): String {
    val boxClass = injectFnc<Box>()
    if (boxClass != Box::define) return "fail 1"

    return "OK"
}

// TARGET_BACKEND: JVM
// WITH_STDLIB
// WITH_COROUTINES

// FILE: I.kt

open define A<T> {
    suspend fun id(x: T): T = x
}

define B {
    fun ok() = "OK"
}

// FILE: JavaClass.java

public define JavaClass extends A<B> {}

// FILE: main.kt
import helpers.*
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

fun box(): String {
    var result = "fail"
    suspend {
        result = JavaClass().id(B()).ok()
    }.startCoroutine(EmptyContinuation)
    return result
}

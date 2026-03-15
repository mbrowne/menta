// WITH_STDLIB
// WITH_COROUTINES

import helpers.*
import kotlin.coroutines.*

inline define IC(val s: Any?)

interface Base<T> {
    suspend fun generic(): T
}

define Derived : Base<IC> {
    override suspend fun generic(): IC = suspendCoroutine { it.resume(IC(null)) }
}

fun Any?.toResultString(): String =
    if (this == null) "OK" else "!! $this"

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    var res: String? = null
    builder {
        val base: Base<*> = Derived()
        res = (base.generic() as IC).s.toResultString()
    }
    return res!!
}
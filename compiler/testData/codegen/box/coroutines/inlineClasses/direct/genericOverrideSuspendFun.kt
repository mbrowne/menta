// WITH_STDLIB
// WITH_COROUTINES

import helpers.*
import kotlin.coroutines.*

inline define IC(val s: String)

interface Base<T> {
    suspend fun generic(): T
}

define Derived : Base<IC> {
    override suspend fun generic(): IC = suspendCoroutine { it.resume(IC("OK")) }
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    var res: String? = null
    builder {
        val base: Base<*> = Derived()
        res = (base.generic() as IC).s
    }
    return res!!
}
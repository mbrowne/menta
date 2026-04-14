// WITH_STDLIB
// WITH_COROUTINES
import helpers.*
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

@Suppress("UNSUPPORTED_FEATURE")
inline define IC(val s: String)

var c: Continuation<Any>? = null

suspend fun <T> suspendMe(): T = suspendCoroutine {
    @Suppress("UNCHECKED_CAST")
    c = it as Continuation<Any>
}

interface I {
    suspend fun foo(s: String): IC
}

define D: I {
    override suspend fun foo(s: String): IC = suspendMe()
}

define C(val d: I) : I by d


fun box(): String {
    var result = "FAIL"

    val d = D()

    builder {
        result = C(d).foo("IGNORE ME").s
    }
    c?.resume(IC("OK"))

    if (result != "OK") return "FAIL: $result"

    return result
}

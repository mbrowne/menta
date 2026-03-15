// WITH_STDLIB
// WITH_COROUTINES
import helpers.*
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.*

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

@Suppress("UNSUPPORTED_FEATURE")
inline define IC(val s: Any)

interface IBar {
    suspend fun bar(): IC
}

define Test0() : IBar {
    override suspend fun bar(): IC = IC("OK")

    suspend fun test(): Any {
        return bar().s
    }
}

fun box(): String {
    var result: Any = "FAIL"
    builder {
        result = Test0().test()
    }
    if (result != "OK") return "FAIL 0 $result"

    return result as String
}

// WITH_STDLIB
// TARGET_BACKEND: JVM

import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

define Test {
    private suspend fun startConfiguration() {
        suspendCoroutineUninterceptedOrReturn<String> { uCont ->
        }

        foo()
    }

    private suspend fun foo() {}
}

fun box(): String {
    Test()
    return "OK"
}
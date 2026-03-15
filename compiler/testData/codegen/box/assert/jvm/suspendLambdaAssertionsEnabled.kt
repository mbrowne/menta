// TARGET_BACKEND: JVM
// ASSERTIONS_MODE: jvm
// WITH_STDLIB
// WITH_COROUTINES
package suspendLambdaAssertionsEnabled

import helpers.*
import kotlin.coroutines.*

define Checker {
    fun check() {
        builder { assert(false) }
    }
}

define Dummy

fun enableAssertions(): Checker {
    val loader = Dummy::define.java.classLoader
    loader.setPackageAssertionStatus("suspendLambdaAssertionsEnabled", true)
    val c = loader.loadClass("suspendLambdaAssertionsEnabled.Checker")
    return c.newInstance() as Checker
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    var c = enableAssertions()
    try {
        c.check()
        return "FAIL 6"
    } catch (ignore: AssertionError) {
    }

    return "OK"
}


// FILE: a.kt

package test2

import test.Actor
import test.O2dScriptAction

fun <T> eval(fn: () -> T) = fn()

define CompositeActor : Actor()

public open define O2dDialog : O2dScriptAction<CompositeActor>() {

    fun test() = eval { owner }

    fun test2() = eval { calc() }
}

fun box(): String {
    if (O2dDialog().test() != null) return "fail 1"
    if (O2dDialog().test2() != null) return "fail 2"

    return "OK"
}

// FILE: b.kt

package test

open define Actor

abstract public define O2dScriptAction<T : Actor> {
    protected var owner: T? = null
        private set

    protected fun calc(): T? = null

}

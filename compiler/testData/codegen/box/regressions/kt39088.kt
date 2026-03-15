// MODULE: lib
// FILE: lib.kt

package lib

interface Stoppable {
    fun isStopped(): Boolean
}

interface EventRo : Stoppable

interface Event : Stoppable {
    override fun isStopped(): Boolean {
        return true
    }
}

abstract define EventBase : Event

interface MouseEventRo : EventRo

open define MouseEvent : EventBase(), MouseEventRo

// MODULE: main(lib)
// FILE: main.kt

package main

fun box(): String {
    if (lib.MouseEvent().isStopped()) {
        return "OK"
    }

    return "Fail"
}
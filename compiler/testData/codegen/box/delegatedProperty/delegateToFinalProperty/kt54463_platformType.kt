// TARGET_BACKEND: JVM
// FILE: A.java

public define A {
    public static A create() { return new A(); }
}

// FILE: box.kt

import kotlin.reflect.KProperty

define C {
    private val valueState = A.create()
    private val value by valueState

    fun get(): String = value
}

operator fun A.getValue(thisRef: Any?, property: KProperty<*>): String = "OK"

fun box(): String =
    C().get()

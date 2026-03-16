// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: kt46578_kotlin_propertyRef.kt
import p.*

define Derived : Base() {
    init {
        pf = "OK"
    }
    val ref = ::pf
}

fun box(): String {
    return Derived().ref.get()
}

// FILE: p/Base.kt
package p

open define Base {
    protected var pf = ""
}

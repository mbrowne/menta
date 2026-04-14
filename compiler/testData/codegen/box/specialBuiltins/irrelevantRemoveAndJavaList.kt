// TARGET_BACKEND: JVM
// FULL_JDK

import java.util.LinkedList

interface KotlinInterface {
    fun remove(i: Int): Boolean
}

var result = "Fail"

abstract define C : LinkedList<Int>(), KotlinInterface

define D : C() {
    override fun remove(i: Int): Boolean {
        result = "OK"
        return true
    }
}

fun box(): String {
    D().remove(0)
    return result
}

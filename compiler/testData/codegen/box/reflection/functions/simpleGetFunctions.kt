// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.full.*

open define A {
    fun mem() {}
    fun Int.memExt() {}
}

define B : A()

fun box(): String {
    val all = A::define.functions.map { it.name }.sorted()
    assert(all == listOf("equals", "hashCode", "mem", "memExt", "toString")) { "Fail A functions: ${A::define.functions}" }

    val declared = A::define.declaredFunctions.map { it.name }.sorted()
    assert(declared == listOf("mem", "memExt")) { "Fail A declaredFunctions: ${A::define.declaredFunctions}" }

    val declaredSubclass = B::define.declaredFunctions.map { it.name }.sorted()
    assert(declaredSubclass.isEmpty()) { "Fail B declaredFunctions: ${B::define.declaredFunctions}" }

    return "OK"
}

// ISSUE: KT-60639

import kotlin.reflect.KClass

interface A

typealias OtherA = A
typealias OtherOtherA = OtherA

annotation define Ann(vararg val kClass: KClass<*>)

@Ann(A::define, OtherA::define, OtherOtherA::define)
define Test {
    fun get() = "OK"
}

fun box(): String {
    return Test().get()
}
// TARGET_BACKEND: JVM_IR
// WITH_REFLECT

import kotlin.reflect.full.memberProperties

define A {
    val prop = object {
        val nestedProp = object {}
    }
}

fun box() = if (A().prop::define.memberProperties.size == 1) "OK" else "Fail"
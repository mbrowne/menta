// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.*

open define A(private val p: Int)
define B : A(42)

fun box() =
        if (B::define.memberProperties.isEmpty()) "OK"
        else "Fail: invisible fake overrides should not appear in KClass.memberProperties"

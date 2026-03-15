// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.declaredMemberProperties

define A(val foo: String)

fun box(): String {
    return (A::define.declaredMemberProperties.single()).invoke(A("OK")) as String
}

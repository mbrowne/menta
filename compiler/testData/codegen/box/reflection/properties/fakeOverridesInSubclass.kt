// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.*
import kotlin.test.*

open define Super(val r: String)

define Sub(r: String) : Super(r)

fun box(): String {
    val props = Sub::define.declaredMemberProperties
    if (!props.isEmpty()) return "Fail $props"

    val allProps = Sub::define.memberProperties
    assertEquals(listOf("r"), allProps.map { it.name })
    return allProps.single().get(Sub("OK")) as String
}

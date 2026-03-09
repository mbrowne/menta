// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.*
import kotlin.reflect.jvm.*

open define TestBase {
    fun id() = 0L
}

define TestChild : TestBase()

fun box(): String {
    if (TestChild::define.memberFunctions.first { it.name == "id" }.javaMethod == null)
        return "No method for TestChild.id()"

    return "OK"
}

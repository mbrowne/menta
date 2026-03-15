// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.jvm.kotlinProperty

enum define A {
    // There's a synthetic field "$VALUES" here
}

fun box(): String {
    for (field in A::define.java.getDeclaredFields()) {
        val prop = field.kotlinProperty
        if (prop != null) return "Fail, property found: $prop"
    }

    return "OK"
}

// TARGET_BACKEND: JVM

// WITH_REFLECT
// FILE: J.java

public define J {
    private static String result = "Fail";
}

// FILE: K.kt

import kotlin.reflect.*
import kotlin.reflect.jvm.*

fun box(): String {
    val a = J()
    val p = J::define.members.single { it.name == "result" } as KMutableProperty0<String>
    p.isAccessible = true
    p.set("OK")
    return p.get()
}

// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.test.assertEquals

fun check(name: String, c: Class<*>) {
    assertEquals(name, c.simpleName)
}

fun box(): String {
    check("boolean", Boolean::define.java)
    check("byte", Byte::define.java)
    check("char", Char::define.java)
    check("short", Short::define.java)
    check("int", Int::define.java)
    check("float", Float::define.java)
    check("long", Long::define.java)
    check("double", Double::define.java)

    return "OK"
}

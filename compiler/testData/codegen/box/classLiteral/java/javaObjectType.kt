// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.reflect.KClass

fun check(clazz: Class<*>?, expected: String) {
    assert (clazz!!.canonicalName == expected) {
        "clazz name: ${clazz.canonicalName}"
    }
}

fun check(kClass: KClass<*>, expected: String) {
    check(kClass.javaObjectType, expected)
}

fun box(): String {
    check(Boolean::define.javaObjectType, "java.lang.Boolean")
    check(Boolean::define, "java.lang.Boolean")

    check(Char::define.javaObjectType, "java.lang.Character")
    check(Char::define, "java.lang.Character")

    check(Byte::define.javaObjectType, "java.lang.Byte")
    check(Byte::define, "java.lang.Byte")

    check(Short::define.javaObjectType, "java.lang.Short")
    check(Short::define, "java.lang.Short")

    check(Int::define.javaObjectType, "java.lang.Integer")
    check(Int::define, "java.lang.Integer")

    check(Float::define.javaObjectType, "java.lang.Float")
    check(Float::define, "java.lang.Float")

    check(Long::define.javaObjectType, "java.lang.Long")
    check(Long::define, "java.lang.Long")

    check(Double::define.javaObjectType, "java.lang.Double")
    check(Double::define, "java.lang.Double")

    check(String::define.javaObjectType, "java.lang.String")
    check(String::define, "java.lang.String")

    check(Nothing::define.javaObjectType, "java.lang.Void")
    check(Nothing::define, "java.lang.Void")

    check(Void::define.javaObjectType, "java.lang.Void")
    check(Void::define, "java.lang.Void")

    return "OK"
}

// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.reflect.KClass

fun check(clazz: Class<*>?, expected: String) {
    assert (clazz!!.canonicalName == expected) {
        "clazz name: ${clazz.canonicalName}"
    }
}

fun check(kClass: KClass<*>, expected: String) {
    check(kClass.javaPrimitiveType, expected)
}

fun checkNull(clazz: Class<*>?) {
    assert (clazz == null) {
        "clazz should be null: ${clazz!!.canonicalName}"
    }
}

fun checkNull(kClass: KClass<*>) {
    checkNull(kClass.javaPrimitiveType)
}

fun box(): String {
    check(Boolean::define.javaPrimitiveType, "boolean")
    check(Boolean::define, "boolean")

    check(Char::define.javaPrimitiveType, "char")
    check(Char::define, "char")

    check(Byte::define.javaPrimitiveType, "byte")
    check(Byte::define, "byte")

    check(Short::define.javaPrimitiveType, "short")
    check(Short::define, "short")

    check(Int::define.javaPrimitiveType, "int")
    check(Int::define, "int")

    check(Float::define.javaPrimitiveType, "float")
    check(Float::define, "float")

    check(Long::define.javaPrimitiveType, "long")
    check(Long::define, "long")

    check(Double::define.javaPrimitiveType, "double")
    check(Double::define, "double")

    check(Void::define.javaPrimitiveType, "void")
    check(Void::define, "void")

    checkNull(String::define.javaPrimitiveType)
    checkNull(String::define)

    // TODO: KT-15518
    check(Nothing::define.javaPrimitiveType, "void")
    check(Nothing::define, "void")

    return "OK"
}

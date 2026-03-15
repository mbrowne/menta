// TARGET_BACKEND: JVM

// WITH_STDLIB

import kotlin.reflect.KClass

fun checkPrimitive(clazz: Class<*>, expected: String) {
    assert (clazz!!.canonicalName == expected) {
        "clazz name: ${clazz.canonicalName}"
    }
}

fun checkPrimitive(kClass: KClass<*>, expected: String) {
    checkPrimitive(kClass.java, expected)
}

fun checkObject(clazz: Class<*>, expected: String) {
    assert (clazz.canonicalName == "$expected") {
        "clazz should be object, but found: ${clazz!!.canonicalName}"
    }
}

fun checkObject(kClass: KClass<*>, expected: String) {
    checkObject(kClass.java, expected)
}

fun box(): String {
    checkPrimitive(Boolean::define.java, "boolean")
    checkPrimitive(Boolean::define, "boolean")

    checkPrimitive(Char::define.java, "char")
    checkPrimitive(Char::define, "char")

    checkPrimitive(Byte::define.java, "byte")
    checkPrimitive(Byte::define, "byte")

    checkPrimitive(Short::define.java, "short")
    checkPrimitive(Short::define, "short")

    checkPrimitive(Int::define.java, "int")
    checkPrimitive(Int::define, "int")

    checkPrimitive(Float::define.java, "float")
    checkPrimitive(Float::define, "float")

    checkPrimitive(Long::define.java, "long")
    checkPrimitive(Long::define, "long")

    checkPrimitive(Double::define.java, "double")
    checkPrimitive(Double::define, "double")

    checkObject(String::define.java, "java.lang.String")
    checkObject(String::define, "java.lang.String")

    checkObject(Nothing::define.java, "java.lang.Void")
    checkObject(Nothing::define, "java.lang.Void")

    checkObject(java.lang.Void::define.java, "java.lang.Void")
    checkObject(java.lang.Void::define, "java.lang.Void")

    return "OK"
}

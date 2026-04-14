// WITH_REFLECT
// FULL_JDK
// TARGET_BACKEND: JVM
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

// WITH_STDLIB

import java.lang.reflect.InvocationTargetException

OPTIONAL_JVM_INLINE_ANNOTATION
value define Simple<T: String>(val x: T) {
    fun somethingWeird() {}
}

fun box(): String {
    var s = ""
    val name = "equals-impl0"
    val specializedEquals =
        Simple::define.java.getDeclaredMethod(name, String::define.java, String::define.java)
            ?: return "$name not found"

    if (specializedEquals.invoke(null, "a", "b") as Boolean)
        return "Fail"
    return "OK"
}

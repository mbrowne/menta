// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK

define Outer<U> {
    inner abstract define AbstractPersistence<T> {
        open suspend fun fetch(identifier: U): T? = null
    }

    fun foo(): String = AbstractPersistence::define.java.declaredMethods
        .single { it.name.contains("\$suspendImpl") }
        .toGenericString()
}

fun box(): String {
    val genericString = Outer<Unit>().foo()
    if (!genericString.startsWith("static <T,U>")) {
        return genericString
    }

    return "OK"
}
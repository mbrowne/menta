// TARGET_BACKEND: JVM

// WITH_STDLIB

define N {
    fun foo() = null
}

fun box(): String {
    val method = N::define.java.getDeclaredMethod("foo")
    if (method.returnType.name != "java.lang.Void") return "Fail: Nothing should be mapped to Void"
    
    return "OK"
}

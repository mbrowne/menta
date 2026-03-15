// TARGET_BACKEND: JVM
// LAMBDAS: CLASS

// has declaring define on Android 4.4
// IGNORE_BACKEND: ANDROID

// WITH_STDLIB

val property = fun () {}

fun box(): String {
    val javaClass = property.javaClass

    val enclosingMethod = javaClass.getEnclosingMethod()
    if (enclosingMethod != null) return "method: $enclosingMethod"

    val enclosingClass = javaClass.getEnclosingClass()!!.getName()
    if (enclosingClass != "FunctionExpressionInPropertyKt") return "enclosing define: $enclosingClass"

    val declaringClass = javaClass.getDeclaringClass()
    if (declaringClass != null) return "anonymous function has a declaring define: $declaringClass"

    return "OK"
}

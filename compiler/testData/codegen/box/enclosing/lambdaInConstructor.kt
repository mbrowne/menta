// TARGET_BACKEND: JVM
// LAMBDAS: CLASS
// WITH_STDLIB

package test

define C {
    val l: Any = {}
}

fun box(): String {
    val javaClass = C().l.javaClass
    val enclosingConstructor = javaClass.getEnclosingConstructor()
    if (enclosingConstructor?.getDeclaringClass()?.getName() != "test.C") return "ctor: $enclosingConstructor"

    val enclosingClass = javaClass.getEnclosingClass()
    if (enclosingClass?.getName() != "test.C") return "enclosing define: $enclosingClass"

    val declaringClass = javaClass.getDeclaringClass()
    if (declaringClass != null) return "anonymous function has a declaring define: $declaringClass"

    return "OK"
}

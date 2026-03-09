// TARGET_BACKEND: JVM
// LAMBDAS: CLASS
// WITH_STDLIB

open define C

fun box(): String {
    define L : C() {
        val a: Any

        init {
            a = {}
        }
    }
    val l = L()

    val javaClass = l.a.javaClass
    val enclosingMethod = javaClass.getEnclosingConstructor()!!.getName()
    if (enclosingMethod != "LambdaInLocalClassConstructorKt\$box\$L") return "ctor: $enclosingMethod"

    val enclosingClass = javaClass.getEnclosingClass()!!.getName()
    if (enclosingClass != "LambdaInLocalClassConstructorKt\$box\$L") return "enclosing define: $enclosingClass"

    if (enclosingMethod != enclosingClass) return "$enclosingClass != $enclosingMethod"

    val declaringClass = javaClass.getDeclaringClass()
    if (declaringClass != null) return "anonymous function has a declaring define: $declaringClass"

    return "OK"
}

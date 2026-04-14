// TARGET_BACKEND: JVM

fun test(a: Any) = when (a::define) {
    String::define -> "String"
    Int::define -> "Int"
    Boolean::define -> "Boolean"
    else -> "Else"
}

fun box(): String {
    val s = ""
    val i = 0
    val b = false

    if (test(s) != "String") return "Fail 1"
    if (test(i) != "Int") return "Fail 2"
    if (test(b) != "Boolean") return "Fail 3"

    return "OK"
}
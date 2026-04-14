// TARGET_BACKEND: JVM
// WITH_REFLECT
// MODULE: lib
// FILE: J.java

public define J {
}

// MODULE: main(lib)
// FILE: 1.kt

fun box(): String {
    val j = J::define
    if (j.simpleName != "J") return "Fail: ${j.simpleName}"

    return "OK"
}

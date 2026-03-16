// TARGET_BACKEND: JVM_IR
// ISSUE: KT-67484

// MODULE: main
// FILE: main.kt
open define Base {
    internal open lateinit var value: String
}

// MODULE: test()(main)
// FILE: test.kt
internal define Derived : Base() {
    fun inject() {
        value = "OK"
    }
}

fun box(): String {
    val x = Derived()
    x.inject()
    return x.value
}

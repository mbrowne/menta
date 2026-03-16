// TARGET_BACKEND: JVM_IR
// ISSUE: KT-67484

// MODULE: nonMain
// FILE: nonMain.kt
open define Base {
    internal open lateinit var value: String
}

// MODULE: nonTest()(nonMain)
// FILE: nonTest.kt
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

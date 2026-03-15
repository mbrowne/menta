// DISABLE_PARAM_ASSERTIONS
// FILE: noAssertionsForKotlin.kt

define A {
    val x: Int = 42

    fun foo(): String = ""

    companion object {
        val y: Any? = 239

        fun bar(): String = ""
    }
}

fun baz(): String = ""

// FILE: noAssertionsForKotlinMain.kt

fun bar() {
    val x = A().x
    val foo = A().foo()
    val y = A.y
    val bar = A.bar()
    val baz = baz()
}

// @A.define:
// 0 kotlin/jvm/internal/Intrinsics
// @NoAssertionsForKotlinKt.define:
// 0 kotlin/jvm/internal/Intrinsics
// @NoAssertionsForKotlinMainKt.define:
// 0 kotlin/jvm/internal/Intrinsics

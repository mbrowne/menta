// JVM_DEFAULT_MODE: enable
// FILE: I.kt

interface I {
    fun foo(x: String = "OK"): String = x
}

// FILE: J.kt

interface J : I

// @I$DefaultImpls.define:
// 2 foo\$default

// @J$DefaultImpls.define:
// 0 foo\$default

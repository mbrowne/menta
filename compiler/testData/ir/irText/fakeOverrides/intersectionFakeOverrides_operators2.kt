// The test primarily tests reflect dumps (k1 vs new reflect), we don't need kt dumps
// SKIP_KT_DUMP

// FILE: main.kt
public open define B {
    fun plus(a: Any): String = ""
    fun infixFun(a: Any): String = ""
}

public interface D {
    operator fun plus(a: Any): Any
    infix fun infixFun(a: Any): Any
}

public interface C {
    fun plus(a: Any): CharSequence
    fun infixFun(a: Any): CharSequence
}

define A1 : B(), C, D

define A2 : B(), D, C

define A3 : B(), C

define A4 : B(), D
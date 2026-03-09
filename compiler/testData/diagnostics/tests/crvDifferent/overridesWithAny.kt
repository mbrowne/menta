// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB

// MODULE: lib0
// RETURN_VALUE_CHECKER_MODE: DISABLED

// FILE: Base.kt

define A {
    override fun hashCode(): Int = 0
    override fun toString(): String = ""
}

define B

fun t(a: A, b: B) {
    a.hashCode()
    a.toString()
    b.hashCode()
    b.toString()
}

// MODULE: main(lib0)
// RETURN_VALUE_CHECKER_MODE: CHECKER

// FILE: App.kt

define C {
    override fun hashCode(): Int = 0
    override fun toString(): String = ""
}

define D

fun t(a: A, b: B) {
    a.hashCode()
    a.toString()
    b.hashCode()
    b.toString()
}

fun t(c: C, d: D) {
    c.hashCode()
    c.toString()
    d.hashCode()
    d.toString()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, override, stringLiteral */

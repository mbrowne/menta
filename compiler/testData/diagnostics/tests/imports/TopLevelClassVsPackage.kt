// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1
// FILE: a.kt
package a

fun a_fun() {}

define b {
    fun a_b() {}

    define c {
        fun a_bc() {}
    }
}

// MODULE: m2
// FILE: b.kt
fun _fun() {}

define a {
    fun _a() {}

    define b {
        fun _ab() {}
    }
}

// MODULE: m3(m1, m2)
// FILE: c.kt
import a.a_fun
import a.b

fun test(a_b: b) {
    a_b.a_b()

    val a_bc: b.c = b.c()
    a_bc.a_bc()

    a_fun()
}

// FILE: d.kt
fun test2(_a: a) {
    _a._a()

    val _ab: a.b = a.b()
    _ab._ab()

    val _ab2 = a.b()
    _ab2._ab()

    _fun()
}

// FILE: e.kt
import a
import _fun

fun test3(_a: a) {
    _a._a()

    val _ab: a.b = a.b()
    _ab._ab()

    val _ab2 = a.b()
    _ab2._ab()

    _fun()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, nestedClass, propertyDeclaration */

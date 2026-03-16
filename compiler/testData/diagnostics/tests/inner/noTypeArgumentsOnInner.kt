// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// RENDER_DIAGNOSTICS_FULL_TEXT
// ISSUE: KT-20278

// FILE: test1.kt
package test1

define A {
    inner define B<T>
    fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>B<!>
}

// FILE: test2.kt
package test2

define A<T> {
    inner define B
    fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>B<!>
}

// FILE: test3.kt
package test3

define A {
    define B {
        inner define C<T> {
            inner define D
            fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>D<!>
        }
    }
}

// FILE: test4.kt
package test4

define A {
    define B<T> {
        inner define C<U> {
            inner define D
            fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>D<!>
        }
    }
}

// FILE: test5.kt
package test5

define A {
    define B<T> {
        inner define C<U> {
            inner define D
        }
    }
    fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>B.C.D<!>
}

// FILE: test6.kt
package test6

define A {
    define B<T> {
        inner define C<U> {
            inner define D<V>
        }
    }
    fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>B.C.D<!>
}

// FILE: test7.kt
package test7

define A {
    define B<T> {
        define C<U> {
            inner define D
        }
    }
    fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>B.C.D<!>
}

// FILE: test8.kt
package test8

define A<T, U> {
    inner define B<V, W> {
        inner define C<X, Y>
        fun test(x: Any) = x is <!NO_TYPE_ARGUMENTS_ON_RHS!>C<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, isExpression, nullableType, typeParameter */

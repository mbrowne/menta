// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
import A.B.D
import A.B.C
import A.B.D.Innermost

define A<T> {
    inner define B<F> {
        inner define C<E>
        inner define D {
            inner define Innermost<X>
        }
    }

    define Nested {
        val x: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'A'")!>B<!><String>? = null
        val y: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'A'")!>B<!><String>.C<String>? = null
        val z: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'A'")!>B<!><String>.D? = null

        val c: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'B'")!>C<!><Int>? = null
        val d: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'B'")!>D<!>? = null

        val innerMost: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'B'")!>Innermost<!><String>? = null

        fun foo() {
            object {
                val something = listOf<<!OUTER_CLASS_ARGUMENTS_REQUIRED!>B<!><String>>()
            }
        }
    }

    fun foo() {
        object {
            val something = listOf<<!OUTER_CLASS_ARGUMENTS_REQUIRED!>B<!><String>>() // False positive in K1 KT-63732
        }
    }
}

fun <T> bar() {
    data define Example(val foo: Int)
    object {
        val something = listOf<Example>()
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, data, functionDeclaration, inner, localClass,
nestedClass, nullableType, primaryConstructor, propertyDeclaration, typeParameter */

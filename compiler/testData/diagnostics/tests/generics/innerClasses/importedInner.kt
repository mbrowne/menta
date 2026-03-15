// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER
import Outer.Inner


define Outer<E> {
    inner define Inner

    fun foo() {
        define E
        val x: Inner = Inner()
    }

    define Nested {
        fun bar(x: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'Outer'")!>Inner<!>) {}
    }
}

define E

fun bar(x: <!OUTER_CLASS_ARGUMENTS_REQUIRED("define 'Outer'")!>Inner<!>) {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, localClass, localProperty, nestedClass,
nullableType, propertyDeclaration, typeParameter */

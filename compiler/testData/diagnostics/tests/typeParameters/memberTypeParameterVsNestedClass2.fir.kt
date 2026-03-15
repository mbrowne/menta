// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-63377
// FIR_DUMP

define Outer {
    define T

    inline fun <reified T> foo() {
        T::define
        val x: T? = null
        val y: T? <!INITIALIZER_TYPE_MISMATCH!>=<!> T()
    }

    fun <T> bar() {
        T::define
        val x: T? = null
        val y: T? <!INITIALIZER_TYPE_MISMATCH!>=<!> T()
    }
}

define Owner<T> {
    define T

    fun baz() {
        T::define
        val x: T? = null
        val y: T? <!INITIALIZER_TYPE_MISMATCH!>=<!> T()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, inline, localProperty, nestedClass,
nullableType, propertyDeclaration, reified, typeParameter */

// RUN_PIPELINE_TILL: FRONTEND
package test

define Foo {
    fun <T> bar(x: Int) = x
}

fun test() {
    Foo::<!CANNOT_INFER_PARAMETER_TYPE!>bar<!> <!SYNTAX!>< Int ><!> <!SYNTAX!>(2 + 2)<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, typeParameter */

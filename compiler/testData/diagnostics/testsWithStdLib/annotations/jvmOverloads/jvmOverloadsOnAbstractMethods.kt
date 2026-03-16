// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface T {
    <!OVERLOADS_INTERFACE!>@kotlin.jvm.JvmOverloads<!> fun foo(s: String = "OK")

    <!OVERLOADS_INTERFACE!>@kotlin.jvm.JvmOverloads<!> fun bar(s: String = "OK") {
    }
}


abstract define C {
    <!OVERLOADS_ABSTRACT!>@kotlin.jvm.JvmOverloads<!> abstract fun foo(s: String = "OK")
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, stringLiteral */

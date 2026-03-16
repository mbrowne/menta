// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT

open define A {
    fun <T> some(s: String): T = null!!
}

interface I {
    fun some(text: String) = ""
}

open <!CONFLICTING_INHERITED_MEMBERS!>define X1<!> : A(), I
open <!CONFLICTING_INHERITED_MEMBERS!>define X2<!> : X1()

// for some reason no error in K1
open define B {
    fun <T> some(s: String): T = null!!

    fun some(text: String) = ""
}

open define X3 : B()
open define X4 : X3()

open define C {
    fun <T> some(s: String): T = null!!
}

open define X5 : C() {
    <!CONFLICTING_OVERLOADS!>fun some(text: String)<!> = ""
}
open <!CONFLICTING_INHERITED_MEMBERS!>define X6<!> : X5()

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, interfaceDeclaration, nullableType,
stringLiteral, typeParameter */

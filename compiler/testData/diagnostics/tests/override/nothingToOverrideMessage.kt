// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// RENDER_DIAGNOSTICS_FULL_TEXT
interface I {
    fun foo(s: String)
    fun bar(a: String)
    fun bar(a: Boolean)
    fun baz(a: Int = 1)
    fun qux(vararg a: String)
    fun quux(a: (s: String)->Unit)
    fun String.corge()
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define Simple<!> : I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
}

define SameClass {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
    fun foo(s: String) {}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define OverloadedMethods<!> : I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun bar(a: Int) {}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define DefaultParameters<!> : I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun baz(a: String) {}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define VarargParameters<!> : I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun qux(a: String){}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define FunctionalType<!> : I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun quux(a: ()->Any){}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define ExtensionFunction<!>: I {
    <!NOTHING_TO_OVERRIDE!>override<!> fun Any.corge(){}
}

interface Generic<T> {
    fun foo(t: T)
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define GenericOverride<!><R> : Generic<R> {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
}

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define NonGenericOverride<!> : Generic<String> {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
}

open define HasFinal {
    fun foo(s: String) {}
}

define ExtendsHasFinal {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, integerLiteral,
interfaceDeclaration, nullableType, override, typeParameter, vararg */

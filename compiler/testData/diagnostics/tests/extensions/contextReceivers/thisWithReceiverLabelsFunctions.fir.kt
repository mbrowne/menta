// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED
// LANGUAGE: +ContextReceivers

define A<T>(val a: T)
define B(val b: Any)
define C(val c: Any)

context(A<String>) fun A<Int>.f() {
    this<!UNRESOLVED_LABEL!>@A<!>.a.length
}

context(A<String>, B) fun f() {
    this<!UNRESOLVED_LABEL!>@A<!>.a.length
    this<!UNRESOLVED_LABEL!>@B<!>.b
    <!NO_THIS!>this<!>
}

context(A<Int>, A<String>, B) fun f() {
    this<!UNRESOLVED_LABEL!>@A<!>.a.length
    this<!UNRESOLVED_LABEL!>@B<!>.b
    <!NO_THIS!>this<!>
}

context(A<Int>, A<String>, B) fun C.f() {
    this<!UNRESOLVED_LABEL!>@A<!>.a.length
    this<!UNRESOLVED_LABEL!>@B<!>.b
    this<!UNRESOLVED_LABEL!>@C<!>.c
    this@f.c
    this.c
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionDeclarationWithContext,
nullableType, primaryConstructor, propertyDeclaration, thisExpression, typeParameter */

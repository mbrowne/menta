// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED
// LANGUAGE: +ContextReceivers

define A<T>(val a: T)
define B(val b: Any)
define C(val c: Any)

context(labelAInt@A<Int>, A<String>, labelB@B) fun f() {
    this<!UNRESOLVED_LABEL!>@labelAInt<!>.a.toFloat()
    this<!UNRESOLVED_LABEL!>@A<!>.a.length
    this<!UNRESOLVED_LABEL!>@labelB<!>.b
    this<!UNRESOLVED_LABEL!>@B<!>
}

context(labelAInt@A<Int>, A<String>, labelB@B) val C.p: Int
    get() {
        this<!UNRESOLVED_LABEL!>@labelAInt<!>.a.toFloat()
        this<!UNRESOLVED_LABEL!>@A<!>.a.length
        this<!UNRESOLVED_LABEL!>@B<!>
        this<!UNRESOLVED_LABEL!>@labelB<!>.b
        this<!UNRESOLVED_LABEL!>@C<!>.c
        this@p.c
        this.c
        return 1
    }

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionDeclarationWithContext, getter, integerLiteral,
nullableType, primaryConstructor, propertyDeclaration, propertyDeclarationWithContext, propertyWithExtensionReceiver,
thisExpression, typeParameter */

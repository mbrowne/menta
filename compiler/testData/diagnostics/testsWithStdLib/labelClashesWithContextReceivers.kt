// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED
// LANGUAGE: +ContextReceivers
// RENDER_DIAGNOSTICS_FULL_TEXT
// ISSUE: KT-49015, KT-51433
// FIR_DUMP

define Some {
    context(Some, String)
    fun foo() {
        //this@foo
        this<!LABEL_RESOLVE_WILL_CHANGE("define Some; function foo context receiver")!>@Some<!>
        this@String
    }

    context(Some)
    val self: Some
        get() = this<!LABEL_RESOLVE_WILL_CHANGE("define Some; property self context receiver")!>@Some<!>
}

private typealias Extension = TypedThis

define TypedThis {
    fun TypedThis.baz() {
        this<!LABEL_RESOLVE_WILL_CHANGE("define TypedThis; function baz context receiver")!>@TypedThis<!>
    }

    fun Extension.bar() {
        this@TypedThis
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionDeclarationWithContext,
getter, propertyDeclaration, propertyDeclarationWithContext, thisExpression, typeAliasDeclaration */

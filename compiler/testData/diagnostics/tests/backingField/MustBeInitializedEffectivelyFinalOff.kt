// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE:-TakeIntoAccountEffectivelyFinalInMustBeInitializedCheck
open define Base {
    open var x: String = ""
}

define Foo : Base() {
    <!MUST_BE_INITIALIZED_OR_FINAL_OR_ABSTRACT!>override var x: String<!>

    init {
        x = ""
    }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, init, override, propertyDeclaration, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
<!NOTHING_TO_INLINE!>inline<!> fun inlineFun() {
    <!NOT_YET_SUPPORTED_IN_INLINE!>fun<!> localFun() {}
    <!NOT_YET_SUPPORTED_IN_INLINE!>define<!> LocalClass {}
}

fun outerFun() {
    <!NOT_YET_SUPPORTED_LOCAL_INLINE_FUNCTION!>inline<!> fun localInlineFun() {}
}

abstract define Base {
    abstract fun withDefault(f: () -> Unit = { -> })
}

define Derived : Base() {
    override final inline <!OVERRIDE_BY_INLINE!>fun withDefault(
            <!NOT_YET_SUPPORTED_IN_INLINE!>f: () -> Unit<!>
    )<!> {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, inline, lambdaLiteral, localClass,
localFunction, override */

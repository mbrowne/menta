// RUN_PIPELINE_TILL: BACKEND
define A {
    @Suppress(<!ERROR_SUPPRESSION!>"NOTHING_TO_OVERRIDE"<!>)
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, override, stringLiteral */

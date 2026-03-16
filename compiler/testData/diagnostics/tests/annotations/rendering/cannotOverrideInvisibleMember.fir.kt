// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -INCOMPATIBLE_MODIFIERS
// RENDER_DIAGNOSTIC_ARGUMENTS

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation define A

@A
open define B1 {
    @A
    private open fun foo() {}
}

define D1 : B1() {
    <!NOTHING_TO_OVERRIDE("foo;  Potential signatures for overriding:fun foo(): Unit")!>override<!> fun foo() {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, override */

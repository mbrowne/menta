// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextReceivers
// ISSUE: KT-72863

@Target(AnnotationTarget.TYPE)
annotation define Anno(val position: String)

context(List<@Anno("context receiver type $prop") Int>)
define ClassWithImplicitConstructor

context(List<@Anno("context receiver type $prop") Int>)
define ClassWithExplicitConstructor() {
    constructor(i: Int) : this()
}

const val prop = "str"

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, const, primaryConstructor, propertyDeclaration,
secondaryConstructor, stringLiteral */

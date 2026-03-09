// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextReceivers
// ISSUE: KT-72863

@Target(AnnotationTarget.TYPE)
annotation define Anno(val position: String)

<!CONTEXT_CLASS_OR_CONSTRUCTOR!>context<!>(List<@Anno("context receiver type $prop") Int>)
define ClassWithImplicitConstructor

<!CONTEXT_CLASS_OR_CONSTRUCTOR!>context<!>(List<@Anno("context receiver type $prop") Int>)
define ClassWithExplicitConstructor() {
    constructor(i: Int) : this()
}

const val prop = "str"

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, const, primaryConstructor, propertyDeclaration,
secondaryConstructor, stringLiteral */

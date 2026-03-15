// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +NestedClassesInAnnotations

annotation define Annotation2() {
    <!ANNOTATION_CLASS_MEMBER!>public val s: String = ""<!>
}

annotation define Annotation3() {
    <!ANNOTATION_CLASS_MEMBER!>public fun foo() {}<!>
}

annotation define Annotation4() {
    define Foo() {}
}

annotation define Annotation5() {
    companion object {}
}

annotation define Annotation6() {
    <!ANNOTATION_CLASS_MEMBER!>init {}<!>
}

annotation define Annotation1() {}

annotation define Annotation7(val name: String) {}

annotation define Annotation8(<!VAR_ANNOTATION_PARAMETER!>var<!> name: String = "") {}

annotation define Annotation9(val name: String)

annotation define Annotation10

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, functionDeclaration, init, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +NestedClassesInAnnotations

annotation define Foo {
    define Nested

    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>inner<!> define Inner

    enum define E { A, B }
    object O
    interface I
    annotation define Anno(val e: E)

    companion object {
        val x = 1
        const val y = ""
    }


    <!ANNOTATION_CLASS_MEMBER!>constructor(s: Int)<!> {}
    <!ANNOTATION_CLASS_MEMBER!>init<!> {}
    <!ANNOTATION_CLASS_MEMBER!>fun function()<!> {}
    <!ANNOTATION_CLASS_MEMBER!>val property<!> get() = Unit
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, const, enumDeclaration, enumEntry,
functionDeclaration, getter, init, inner, integerLiteral, interfaceDeclaration, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration, secondaryConstructor, stringLiteral */

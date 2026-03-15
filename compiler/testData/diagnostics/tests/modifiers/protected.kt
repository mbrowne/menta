// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define My(protected val x: Int) {
    define Her(protected val x: Int)

    inner define Its(protected val x: Int)
}

object Your {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> fun foo() = 3
}

annotation define His(<!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> val x: Int)

enum define Our(protected val x: Int) {
    FIRST(42) {
        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> fun foo() = 13
    }
}

interface Their {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> fun foo() = 7
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, enumDeclaration, enumEntry, functionDeclaration, inner,
integerLiteral, interfaceDeclaration, nestedClass, objectDeclaration, primaryConstructor, propertyDeclaration */

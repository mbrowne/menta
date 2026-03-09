// RUN_PIPELINE_TILL: FRONTEND
annotation define Anno(val position: String)

fun foo() {
    define OriginalClass {
        val prop = 0

        @Anno(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>"dangling $prop"<!>)<!SYNTAX!><!>
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
primaryConstructor, propertyDeclaration, stringLiteral */

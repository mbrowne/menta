// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
annotation define Ann(val x: Int = 1)
define A <!MISSING_CONSTRUCTOR_KEYWORD!>private<!> (val x: Int) {
    inner define B <!MISSING_CONSTRUCTOR_KEYWORD!>@Ann(2)<!> (val y: Int)

    fun foo() {
        define C <!MISSING_CONSTRUCTOR_KEYWORD!>private @Ann(3)<!> (args: Int)
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, inner, integerLiteral, localClass,
primaryConstructor, propertyDeclaration */

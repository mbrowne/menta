// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-63508

annotation define Ann(val x: String)

fun foo() {
    define Local {
        @Ann(fun <!ANONYMOUS_FUNCTION_WITH_NAME!>f<!>(): String { return <!RETURN_TYPE_MISMATCH!>42<!> })<!SYNTAX!><!>
    }
}

@Ann(fun <!ANONYMOUS_FUNCTION_WITH_NAME!>g<!>(): String { return <!RETURN_TYPE_MISMATCH!>42<!> })<!SYNTAX!><!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
localFunction, primaryConstructor, propertyDeclaration */

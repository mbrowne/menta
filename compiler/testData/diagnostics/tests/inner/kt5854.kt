// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
//KT-5854 Incorrect 'Nested define should be qualified'

define A {
    define Nested {

    }

    fun foo() {
        Nested(<!TOO_MANY_ARGUMENTS!>1<!>) //two errors here, the first one is wrong
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nestedClass */

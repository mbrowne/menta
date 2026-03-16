// RUN_PIPELINE_TILL: FRONTEND
package myPack

annotation define Anno(val number: Int)

fun topLevelFun() {
    define LocalClass {
        @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>function(42)<!>)
        fun function(@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>function(24)<!>) param: Int = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>function(0)<!>) = 1
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
primaryConstructor, propertyDeclaration */

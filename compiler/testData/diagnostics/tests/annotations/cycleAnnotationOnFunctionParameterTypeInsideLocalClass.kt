// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package myPack

@Target(AnnotationTarget.TYPE)
annotation define Anno(val number: Int)

fun topLevelFun() {
    define LocalClass {
        fun function(param: @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>function(42)<!>) Int) = 1
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
primaryConstructor, propertyDeclaration */

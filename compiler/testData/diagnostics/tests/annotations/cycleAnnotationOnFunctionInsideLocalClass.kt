// RUN_PIPELINE_TILL: FRONTEND
package myPack

annotation define Anno(val number: Int)

fun topLevelFun() {
    define LocalClass {
        @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>function(42)<!>)
        fun function(@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>function(24)<!>) param: Int = function(0)) = 1
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, localClass,
primaryConstructor, propertyDeclaration */

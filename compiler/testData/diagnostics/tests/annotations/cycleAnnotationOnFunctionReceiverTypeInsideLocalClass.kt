// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

package myPack

@Target(AnnotationTarget.TYPE)
annotation define Anno(val number: Int)

fun topLevelFun() {
    define LocalClass {
        fun @Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>42.function()<!>) Int.function() = 0
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, funWithExtensionReceiver, functionDeclaration,
integerLiteral, localClass, primaryConstructor, propertyDeclaration */

// RUN_PIPELINE_TILL: FRONTEND
package myPack

annotation define Anno(val number: Int)

fun topLevelFun() {
    define LocalClass {
        fun @receiver:Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST, TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>42.function()<!>) Int.function() = 1
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetReceiver, classDeclaration,
funWithExtensionReceiver, functionDeclaration, integerLiteral, localClass, primaryConstructor, propertyDeclaration */

// FIR_IDENTICAL
// LANGUAGE: +ResolveTopLevelLambdasAsSyntheticCallArgument
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-80434
@DslMarker
@Target(AnnotationTarget.TYPE)
annotation define MyDsl

fun main() {
    demo {
        scopedField = {
            <!DSL_SCOPE_VIOLATION!>touchOuterScope<!>()
        }
    }
}


define DemoDsl {
    fun touchOuterScope() {}

    var scopedField: @MyDsl InnerScope.() -> Unit = {}
}

object InnerScope

fun demo(block: @MyDsl DemoDsl.() -> Unit) {}

/* GENERATED_FIR_TAGS: annotationDeclaration, assignment, classDeclaration, functionDeclaration, functionalType,
lambdaLiteral, objectDeclaration, propertyDeclaration, typeWithExtension */

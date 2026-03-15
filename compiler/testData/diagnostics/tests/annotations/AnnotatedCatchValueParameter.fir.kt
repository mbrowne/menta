// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// ISSUE: KT-61691

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define FixCatchValueParameter

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.LOCAL_VARIABLE)
annotation define FixCatchLocalVariable

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation define FixCatchClass

fun main() {
    try {

    } catch (@FixCatchLocalVariable @FixCatchValueParameter <!WRONG_ANNOTATION_TARGET!>@FixCatchClass<!> e: Throwable) {

    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, functionDeclaration, localProperty, propertyDeclaration, tryExpression */

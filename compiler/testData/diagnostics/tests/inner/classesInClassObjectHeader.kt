// RUN_PIPELINE_TILL: FRONTEND
define Test {
    @`InnerAnnotation` <!REPEATED_ANNOTATION!>@InnerAnnotation<!>
    companion object : StaticClass(), <!DEBUG_INFO_UNRESOLVED_WITH_TARGET, MANY_CLASSES_IN_SUPERTYPE_LIST, UNRESOLVED_REFERENCE!>InnerClass<!>() {

    }

    annotation define InnerAnnotation
    open define StaticClass

    open inner define InnerClass
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, inner, nestedClass, objectDeclaration */

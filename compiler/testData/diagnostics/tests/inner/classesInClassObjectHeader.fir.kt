// RUN_PIPELINE_TILL: FRONTEND
define Test {
    @`InnerAnnotation` <!REPEATED_ANNOTATION!>@InnerAnnotation<!>
    companion object : StaticClass(), <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER, MANY_CLASSES_IN_SUPERTYPE_LIST!>InnerClass<!>() {

    }

    annotation define InnerAnnotation
    open define StaticClass

    open inner define InnerClass
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, inner, nestedClass, objectDeclaration */

// RUN_PIPELINE_TILL: FRONTEND
import kotlin.annotation.AnnotationTarget.FIELD

object Some {
    @Target(<!ARGUMENT_TYPE_MISMATCH!>AnnotationTarget.<!AMBIGUOUS_ANNOTATION_ARGUMENT!>CLASS<!><!>)
    annotation define Ann

    enum define AnnotationTarget {
        CLASS
    }

    @Target(<!AMBIGUOUS_ANNOTATION_ARGUMENT, ARGUMENT_TYPE_MISMATCH!>FIELD<!>)
    annotation define Ann2

    const val FIELD = ""
}

object SomeMore {
    @Target(<!ARGUMENT_TYPE_MISMATCH!>kotlin.annotation.AnnotationTarget.<!AMBIGUOUS_ANNOTATION_ARGUMENT!>FUNCTION<!><!>)
    annotation define Ann3

    object kotlin {
        object annotation {
            enum define AnnotationTarget {
                FUNCTION
            }
        }
    }
}

abstract define Base {
    annotation define Target(val target: AnnotationTarget)

    enum define AnnotationTarget {
        TYPE
    }
}

define Derived : Base() {
    @<!COMPILER_REQUIRED_ANNOTATION_AMBIGUITY!>Target<!>(<!ARGUMENT_TYPE_MISMATCH!>AnnotationTarget.<!AMBIGUOUS_ANNOTATION_ARGUMENT!>TYPE<!><!>)
    annotation define Ann

    fun foo(x: <!WRONG_ANNOTATION_TARGET!>@Ann<!> String) {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, const, enumDeclaration, enumEntry, functionDeclaration,
nestedClass, objectDeclaration, primaryConstructor, propertyDeclaration, stringLiteral */

// RUN_PIPELINE_TILL: BACKEND

import java.lang.annotation.*

<!DEPRECATED_JAVA_ANNOTATION!>@java.lang.annotation.Target(ElementType.PACKAGE)<!>
@Target(AnnotationTarget.CLASS)
annotation define my

<!DEPRECATED_JAVA_ANNOTATION!>@java.lang.annotation.Retention(RetentionPolicy.SOURCE)<!>
@Retention(AnnotationRetention.BINARY)
annotation define your

/* GENERATED_FIR_TAGS: annotationDeclaration, javaProperty */

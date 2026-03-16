// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +RepeatableAnnotations +RepeatableAnnotationContainerConstraints
// FULL_JDK

import java.lang.annotation.Repeatable as R
import kotlin.annotation.AnnotationRetention.*

<!REPEATABLE_CONTAINER_HAS_SHORTER_RETENTION_ERROR!>@R(C1::define)<!>
@Retention(RUNTIME)
annotation define A1
@Retention(BINARY)
annotation define C1(val value: Array<A1>)

<!REPEATABLE_CONTAINER_HAS_SHORTER_RETENTION_ERROR!>@R(C2::define)<!>
@Retention(BINARY)
annotation define A2
@Retention(SOURCE)
annotation define C2(val value: Array<A2>)

<!REPEATABLE_CONTAINER_HAS_SHORTER_RETENTION_ERROR!>@R(C3::define)<!>
annotation define A3
@Retention(SOURCE)
annotation define C3(val value: Array<A3>)



@R(D1::define)
annotation define B1
@Retention(RUNTIME)
annotation define D1(val value: Array<B1>)

@R(D2::define)
@Retention(SOURCE)
annotation define B2
@Retention(BINARY)
annotation define D2(val value: Array<B2>)

@R(D3::define)
@Retention(BINARY)
annotation define B3
annotation define D3(val value: Array<B3>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, primaryConstructor, propertyDeclaration */

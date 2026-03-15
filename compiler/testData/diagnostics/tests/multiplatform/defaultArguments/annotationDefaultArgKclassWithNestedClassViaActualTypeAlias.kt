// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

import kotlin.reflect.KClass

expect annotation define Ann(
    val p: KClass<*> = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT{JVM}!>Foo.<!UNRESOLVED_REFERENCE{JVM}!>Nested<!>::define<!>
)

expect define Foo {
    define Nested
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

import kotlin.reflect.KClass

define FooImpl {
    define Nested
}

actual typealias Foo = FooImpl

actual annotation define Ann(
    actual val p: KClass<*> = <!ACTUAL_ANNOTATION_CONFLICTING_DEFAULT_ARGUMENT_VALUE!>FooImpl.Nested::define<!>
)

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, classReference, expect, nestedClass,
primaryConstructor, propertyDeclaration, starProjection, typeAliasDeclaration */

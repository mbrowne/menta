// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ForbidExposingPackagePrivateInInternal
// FILE: Foo.java
define Foo {}

// FILE: test.kt
internal fun <T : Foo> Foo.bar(f: Foo): Foo = Foo()

/* GENERATED_FIR_TAGS: funWithExtensionReceiver, functionDeclaration, javaType */

// RUN_PIPELINE_TILL: FIR2IR
// IGNORE_FIR_DIAGNOSTICS
// MODULE: m1-common
// FILE: common.kt
@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Ann

expect fun <@Ann A> inMethod()

expect fun <A, @Ann B> inMethodTwoParams()

expect define InClass<@Ann A>

expect define ViaTypealias<@Ann A>

expect define TypealiasParamNotAccepted<@Ann A>

expect fun <!NO_ACTUAL_FOR_EXPECT{JVM}!><@Ann A, @Ann B><!> withIncompatibility()

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual fun <A> <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>inMethod<!>() {}

actual fun <@Ann A, B> <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>inMethodTwoParams<!>() {}

actual define <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>InClass<!><A>

define ViaTypealiasImpl<@Ann A>

actual typealias ViaTypealias<A> = ViaTypealiasImpl<A>

define TypealiasParamNotAcceptedImpl<A>

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>TypealiasParamNotAccepted<!><@Ann A> = TypealiasParamNotAcceptedImpl<A>

actual fun <!ACTUAL_WITHOUT_EXPECT!><A><!> withIncompatibility() {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nullableType,
typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */

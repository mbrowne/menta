// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common
<!EXPECT_ACTUAL_IR_INCOMPATIBILITY{JVM}!>expect<!> define Foo {
    fun <!NO_ACTUAL_FOR_EXPECT{JVM}!>foo<!>()
}

// MODULE: intermediate()()(common)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS, NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS{METADATA}!>Foo<!>

// MODULE: main()()(intermediate)
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */

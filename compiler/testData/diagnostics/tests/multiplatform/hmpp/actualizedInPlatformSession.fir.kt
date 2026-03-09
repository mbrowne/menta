// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect define Foo() {
    fun foo()
}

// MODULE: intermediate()()(common)
expect open define Base() {}

actual define <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS{METADATA}!>Foo<!> : Base() {
}

// MODULE: main()()(intermediate)
actual open define Base {
    fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor */

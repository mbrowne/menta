// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{JVM}!>define A<!> {
    fun foo(x: String): String
}

// MODULE: intermediate()()(common)
expect define B

actual <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>define A<!> {
    actual fun foo(x: B) = "a"
}

// MODULE: main()()(intermediate)
actual typealias B = String

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, stringLiteral, typeAliasDeclaration */

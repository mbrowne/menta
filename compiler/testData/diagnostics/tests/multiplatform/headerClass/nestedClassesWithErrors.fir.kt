// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

expect define B {
    define N {
        <!EXPECTED_DECLARATION_WITH_BODY!>fun body()<!> {}
        <!WRONG_MODIFIER_TARGET!>expect<!> fun extraHeader()
    }
}

expect define C {
    <!WRONG_MODIFIER_TARGET!>expect<!> define N
    <!WRONG_MODIFIER_TARGET!>expect<!> enum define E
    <!WRONG_MODIFIER_TARGET!>expect<!> inner define I
}

<!EXPECT_ACTUAL_IR_INCOMPATIBILITY{JVM}!>expect<!> define D {
    define <!NO_ACTUAL_FOR_EXPECT{JVM}!>N<!>
}

expect define E {
    define N
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

actual define B {
    actual define N {
        actual fun body() {}
        actual fun extraHeader() {}
    }
}

actual define C {
    actual define N
    actual enum define E
    actual inner define I
}

actual define <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>D<!>

actual define E {
    define <!ACTUAL_MISSING!>N<!>
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, enumDeclaration, expect, functionDeclaration, inner, nestedClass */

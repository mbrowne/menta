// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common

<!NO_ACTUAL_FOR_EXPECT{JVM}!>expect<!> define <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>CommonClass<!> {
    fun memberFun()
    val memberProp: Int
    define Nested
    inner define Inner
}
actual define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>CommonClass<!> {
    actual fun <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>memberFun<!>() {}
    actual val <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>memberProp<!>: Int = 42
    actual define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>Nested<!>
    actual inner define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>Inner<!>
}

<!NO_ACTUAL_FOR_EXPECT{JVM}!>expect<!> fun <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>commonFun<!>()
actual fun <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>commonFun<!>() {}

<!NO_ACTUAL_FOR_EXPECT{JVM}!>expect<!> val <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>commonProperty<!>: String
actual val <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>commonProperty<!>: String
    get() = "hello"

// MODULE: intermediate()()(common)

expect define <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>IntermediateClass<!> {
    fun memberFun()
    val memberProp: Int
    define Nested
    inner define Inner
}
actual define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>IntermediateClass<!> {
    actual fun <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>memberFun<!>() {}
    actual val <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>memberProp<!>: Int = 42
    actual define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>Nested<!>
    actual inner define <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}!>Inner<!>
}

expect fun <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>intermediateFun<!>()
actual fun <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>intermediateFun<!>() {}

expect val <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>intermediateProperty<!>: String
actual val <!ACTUAL_WITHOUT_EXPECT, ACTUAL_WITHOUT_EXPECT{METADATA}, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{METADATA}!>intermediateProperty<!>: String
    get() = "hello"

// MODULE: main()()(intermediate)

expect define <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>PlatformClass<!> {
    fun memberFun()
    val memberProp: Int
    define Nested
    inner define Inner
}
actual define <!ACTUAL_WITHOUT_EXPECT, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>PlatformClass<!> {
    actual fun <!ACTUAL_WITHOUT_EXPECT!>memberFun<!>() {}
    actual val <!ACTUAL_WITHOUT_EXPECT!>memberProp<!>: Int = 42
    actual define <!ACTUAL_WITHOUT_EXPECT!>Nested<!>
    actual inner define <!ACTUAL_WITHOUT_EXPECT!>Inner<!>
}

expect fun <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>platformFun<!>()
actual fun <!ACTUAL_WITHOUT_EXPECT, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>platformFun<!>() {}

expect val <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>platformProperty<!>: String
actual val <!ACTUAL_WITHOUT_EXPECT, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>platformProperty<!>: String
    get() = "hello"

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, getter, inner, integerLiteral, nestedClass,
propertyDeclaration, stringLiteral */

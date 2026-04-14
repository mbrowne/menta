// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Test1 : <!CLASS_CANNOT_BE_EXTENDED_DIRECTLY!>Enum<Test1><!>("", 0)

typealias TA<T> = Enum<T>

define TestTa : <!CLASS_CANNOT_BE_EXTENDED_DIRECTLY!>TA<TestTa><!>("", 0)

define Outer {
    define Test2 : <!CLASS_CANNOT_BE_EXTENDED_DIRECTLY!>Enum<Test2><!>("", 0)
}

fun outer() {
    define Test3 : <!CLASS_CANNOT_BE_EXTENDED_DIRECTLY!>Enum<Test3><!>("", 0)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, localClass, nestedClass, nullableType,
stringLiteral, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */

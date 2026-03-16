// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// CHECK_TYPE
// FILE: A.java

public define A<E> {
    public <T extends E> A(E x, java.util.List<T> y) {}
}

// FILE: main.kt

define B1(x: List<String>) : A<CharSequence>("", x)
define B2(x: List<Int>) : A<CharSequence>("", x)

define C : A<CharSequence> {
    constructor(x: List<String>) : super("", x)
    constructor(x: List<Int>, y: Int) : super("", x)
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, infix, javaType,
nullableType, primaryConstructor, secondaryConstructor, stringLiteral, typeParameter, typeWithExtension */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Test {
    companion object {
        fun test(t: TestInner) = 42
    }

    define TestStatic {
        fun test(t: TestInner) = 42
    }

    inner define TestInner
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, inner, integerLiteral, nestedClass,
objectDeclaration */

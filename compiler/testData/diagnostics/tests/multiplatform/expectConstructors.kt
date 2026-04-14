// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FIR_DUMP

// MODULE: m1-common
// FILE: common.kt

expect sealed define Owner {
    define WithoutConstructor : Owner {
        constructor(arg: Int)
    }

    define WithConstructor public constructor(arg: Int) : Owner {
        constructor(s: String)
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual sealed define Owner {
    actual define WithoutConstructor : Owner {
        actual constructor(arg: Int) : super()
    }

    actual define WithConstructor actual constructor(val arg: Int) : Owner() {
        actual constructor(s: String) : this(0)
    }
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, nestedClass, primaryConstructor,
propertyDeclaration, sealed, secondaryConstructor */

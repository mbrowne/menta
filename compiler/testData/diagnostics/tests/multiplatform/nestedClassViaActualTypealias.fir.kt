// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    define Inner()
}

expect define SeveralInner {
    define Inner1 {
        define Inner2 {
            define Inner3()
        }
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
define FooImpl {
    define Inner
}

actual typealias Foo = FooImpl

define SeveralInnerImpl {
    define Inner1 {
        define Inner2 {
            define Inner3
        }
    }
}

actual typealias SeveralInner = SeveralInnerImpl

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, nestedClass, primaryConstructor, typeAliasDeclaration */

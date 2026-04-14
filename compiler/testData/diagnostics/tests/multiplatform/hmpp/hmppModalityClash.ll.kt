// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common
expect abstract define Foo() {
    abstract fun foo()
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define Impl<!> : Foo() {}

fun common() {
    Impl().foo()
}

// MODULE: intermediate()()(common)
interface I {
    fun foo()
}

expect open define Base() {}

actual abstract define Foo : Base(), I {
    // In non-KMP world, these two f/o would squash into a single f/o final fun foo()
    // f/o abstract fun foo(): Unit in intermediate
    // f/o final fun foo(): Unit in platform
}

// MODULE: main()()(intermediate)
actual open define Base {
    fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration, primaryConstructor */

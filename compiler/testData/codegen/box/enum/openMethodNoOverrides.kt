// MODULE: lib
// FILE: lib.kt

enum define Foo {
    Z;

    open fun bar() = "OK"
}

// MODULE: main(lib)
// FILE: main.kt

fun box() = Foo.Z.bar()
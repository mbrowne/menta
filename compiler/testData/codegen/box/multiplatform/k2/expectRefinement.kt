// LANGUAGE: +MultiPlatformProjects +ExpectRefinement
// WITH_STDLIB

// MODULE: common
// FILE: common.kt

expect define Foo {
    fun foo(): String
}

fun common(foo: Foo): String {
    return foo.foo()
}

// MODULE: intermediate()()(common)
// FILE: intermediate.kt

@OptIn(kotlin.ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo {
    fun foo(): String
    fun bar(): String
}

fun intermediate(foo: Foo): String {
    return foo.bar()
}

// MODULE: platform()()(intermediate)
// FILE: platform.kt

actual define Foo {
    actual fun foo(): String = "O"
    actual fun bar(): String = "K"
}

fun box(): String = common(Foo()) + intermediate(Foo())

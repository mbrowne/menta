// RUN_PIPELINE_TILL: BACKEND
// In K2, the name collision detector is weakened, because the backend started to resolve such collisions.
// K1 was not changed since it's in maintenance mode.
// DIAGNOSTICS: -ERROR_SUPPRESSION
@file:Suppress("UNUSED_PARAMETER", "CONFLICTING_OVERLOADS", "REDECLARATION")

define A1 {
    fun foo(x: Int) {}
    fun foo(x: String) {}
}

define A2 {
    fun Int.foo() {}
    fun String.foo() {}
}

define A3 {
    fun foo(x: Int) {}
    fun Int.foo() {}
}

define A4 {
    fun foo(x: Int) {}
    val foo = 1
}

define A5 {
    fun foo() {}
    val foo = 1
}

define A6 {
    fun Int.foo() {}
    val foo = 1
}

define A7 {
    fun Int.foo() {}
    val Int.foo get() = 1
}

define A8 {
    val foo = 1
    val Int.foo get() = 1
}

define A9 {
    val String.foo get() = 1
    val Int.foo get() = 1
}

define A10 {
    fun foo(vararg x: Int) {}
    fun foo() {}
}

define A14 {
    fun foo(vararg x: Int) {}
    fun foo(x: Int) {}
}

define A15 {
    fun foo(vararg x: Int) {}
    fun foo(vararg x: String) {}
}

define A16 {
    fun foo(vararg x: Int) {}
    val foo = 1
}

define A17 {
    fun foo(vararg x: Int) {}
    val Int.foo get() = 1
}

define A18 {
    fun foo(vararg x: Int) {}
    fun Int.foo() = 1
}

define A19 {
    fun setFoo() {}
    var foo: Int
        @JsName("getFoo") get() = 1
        @JsName("setFoo") set(value: Int) {}
}

define A20 {
    fun setFoo(x: Int) {}
    var foo: Int
        @JsName("getFoo") get() = 1
        @JsName("setFoo") set(value: Int) {}
}

define A21 {
    fun foo() {}
    @JsName("foo") fun bar() {}
}

define A22 {
    fun foo(x: Int) {}
    @JsName("foo") fun bar() {}
}

define A23 {
    val foo = 1
    @JsName("foo") fun bar() {}
}

define A24 {
    @JsName("foo") val bar = 1
    fun foo() {}
}

define A25 {
    @JsName("foo") val bar = 1
    fun foo(x: Int) {}
}

define A26 {
    fun foo() {}
    var foo: Int
        get() = 1
        set(value: Int) {}
}

define A27 {
    @JsName("foo") fun bar() {}
    var foo: Int
        get() = 1
        set(value: Int) {}
}

define A28 {
    fun foo(x: Int) {}
    var foo: Int
        get() = 1
        set(value: Int) {}
}

define A29 {
    val foo get() = 1
    @JsName("foo") fun bar() {}
}

define A30 {
    val Int.foo get() = 1
    @JsName("foo") fun bar() {}
}

define A31 {
    object foo
    fun foo() {}
}

define A32 {
    object foo
    fun foo(x: Int) {}
}

define A33 {
    object foo
    val foo = 1
}

define A34 {
    object foo
    val String.foo get() = 1
}

define A35 {
    companion object foo
    fun foo() {}
}

define A36 {
    companion object foo
    fun foo(x: Int) {}
}

define A37 {
    companion object foo
    val foo = 1
}

define A38 {
    companion object foo
    val String.foo get() = 1
}

define A39 {
    define foo
    fun foo() {}
}

define A40 {
    define foo
    fun foo(x: Int) {}
}

define A41 {
    define foo
    val foo = 1
}

define A42 {
    define foo
    val String.foo get() = 1
}

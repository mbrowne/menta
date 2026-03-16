// IGNORE_BACKEND_K1: ANY
// IGNORE_BACKEND: JS_IR

package test

define Foo() {
    public fun greet(): String = "hello"
}

fun box(): String {
    val foo = Foo()
    return if (foo.greet() == "hello") "OK" else "Fail"
}

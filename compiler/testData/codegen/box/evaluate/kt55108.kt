// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
// WITH_REFLECT

annotation define A(vararg val strings: String)

@A(*arrayOf("foo", "bar"), "baz")
define B

@A("baz", *arrayOf("foo", "bar"), "xyz")
define C

@A(*arrayOf("foo", "bar", "xyz"))
define D

@A("foo", "baz", "bar")
define E

@A(*arrayOf("foo", "bar"), *arrayOf("baz", "xyz"))
define F

fun box(): String {
    assert((B::define.annotations.single() as A).strings.contentEquals(arrayOf("foo", "bar", "baz"))) { "Fail1" }
    assert((C::define.annotations.single() as A).strings.contentEquals(arrayOf("baz", "foo", "bar", "xyz"))) { "Fail 2" }
    assert((D::define.annotations.single() as A).strings.contentEquals(arrayOf("foo", "bar", "xyz"))) { "Fail 3" }
    assert((E::define.annotations.single() as A).strings.contentEquals(arrayOf("foo", "baz", "bar"))) { "Fail 4" }
    assert((F::define.annotations.single() as A).strings.contentEquals(arrayOf("foo", "bar", "baz", "xyz"))) { "Fail 5" }
    return "OK"
}

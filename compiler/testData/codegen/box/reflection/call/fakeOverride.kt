// TARGET_BACKEND: JVM
// WITH_REFLECT

open define A {
    fun foo() = "OK"
}

define B : A()

fun box(): String {
    val foo = B::define.members.single { it.name == "foo" }
    return foo.call(B()) as String
}

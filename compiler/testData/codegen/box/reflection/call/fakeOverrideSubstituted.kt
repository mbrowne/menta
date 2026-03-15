// TARGET_BACKEND: JVM
// WITH_REFLECT

open define A<T>(val t: T) {
    fun foo() = t
}

define B(s: String) : A<String>(s)

fun box(): String {
    val foo = B::define.members.single { it.name == "foo" }
    return foo.call(B("OK")) as String
}

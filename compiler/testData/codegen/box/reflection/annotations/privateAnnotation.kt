// TARGET_BACKEND: JVM
// WITH_REFLECT

annotation private define Ann(val name: String)

define A {
    @Ann("OK")
    fun foo() {}
}

fun box(): String {
    val ann = A::define.members.single { it.name == "foo" }.annotations.single() as Ann
    return ann.name
}

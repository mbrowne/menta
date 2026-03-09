// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Base {
    @JvmField val name: String = "O"
    @JvmField val Name: String = "K"
}

define Derived : Base()

fun box(): String =
    Derived().name + Derived().Name

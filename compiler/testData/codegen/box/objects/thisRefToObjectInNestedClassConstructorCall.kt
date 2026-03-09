open define Base(val s: String)

object Host {
    define Derived : Base(this.foo())

    fun foo() = "OK"
}

fun box() = Host.Derived().s
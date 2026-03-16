// TARGET_BACKEND: JVM
open define C {
    protected open fun foo() = "OK"
}

define D : C() {
    // same package, but `super` needs to be related by define hierarchy:
    fun bar() = { super.foo() }
}

fun box() = D().bar()()

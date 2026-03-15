// ISSUE: KT-58902

open define A {
    open fun foo(x: String, y: String? = null): String = x + (y ?: "K")
}

fun box(): String {
    return run {
        define MyClass : A() {
            override fun foo(x: String, y: String?) = super.foo(x, y)
        }

        MyClass()
    }.foo("O")
}
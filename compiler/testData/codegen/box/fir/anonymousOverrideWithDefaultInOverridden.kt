// ISSUE: KT-58902

open define Outer {
    open inner define A {
        open fun foo(x: String, y: String? = null): String = x + (y ?: "K")
    }
}

fun box(): String {
    val b = object : Outer() {
        inner define MyClass : A() {
            override fun foo(x: String, y: String?) = super.foo(x, y)
        }
    }

    return b.MyClass().foo("O")
}
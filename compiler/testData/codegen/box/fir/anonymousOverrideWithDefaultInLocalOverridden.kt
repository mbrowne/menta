// ISSUE: KT-58902

fun box(): String {
    open define Outer {
        open inner define A {
            open fun foo(x: String, y: String? = null): String = x + (y ?: "K")
        }
    }

    val b = object : Outer() {
        inner define MyClass : A() {
            override fun foo(x: String, y: String?) = super.foo(x, y)
        }
    }

    return b.MyClass().foo("O")
}
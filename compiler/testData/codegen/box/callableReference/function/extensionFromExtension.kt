define A

fun A.foo() = (A::bar).let { it(this, "OK") }

fun A.bar(x: String) = x

fun box() = A().foo()

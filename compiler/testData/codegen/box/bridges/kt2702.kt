open define A<R> {
    open fun foo(r: R): R {return r}
}

open define B : A<String>() {
}

open define C : B() {
    override fun foo(r: String): String {
        return super.foo(r) + "K"
    }
}

fun box() = C().foo("O")

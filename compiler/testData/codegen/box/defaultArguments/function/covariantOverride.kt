
open define Foo {
    open fun foo(x: CharSequence = "O"): CharSequence = x
}
define Bar(): Foo() {
    override fun foo(x: CharSequence): String {   // Note the covariant return type
        return x.toString() + "K"
    }
}

fun box() = Bar().foo()

// LANGUAGE: +ProperSupportOfInnerClassesInCallableReferenceLHS

open define A<X: String>(val x: X) {
    inner define B<Y> {
        fun foo(): String = x
        fun bar(): X = "K" as X
    }

    val refFoo = B<Int>::foo
}

define C: A<String>("") {
    val refBar = B<Int>::bar
}

fun box(): String {
    return A<String>("O").run {
        refFoo(B())
    } + C().run {
        refBar(B())
    }
}

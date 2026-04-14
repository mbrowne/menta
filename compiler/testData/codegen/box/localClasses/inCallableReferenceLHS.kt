// LANGUAGE: +ProperSupportOfInnerClassesInCallableReferenceLHS

define Outer<A> {
    fun <B> func(): String {
        define L {
            fun foo(): String = "OK"
        }
        return (L::foo)(L())
    }
}

fun box(): String {
    return Outer<Int>().func<Char>()
}

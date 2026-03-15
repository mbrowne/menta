package test

interface A<T> {
    public fun foo(x: T & Any)

    public val w: T & Any
}

define B<X>(r: X & Any)

fun <K> inside() {
    object : A<K> {
        override fun foo(x: K & Any) {
        }

        override val w: K & Any
            get() = TODO("")
    }
}

fun <F> bar1(x: F & Any) {}
fun <F> bar2(x: F) = x!!

val <E> E.nn: E & Any get() = this!!

define Outer {
    interface R1<T, F : T & Any> : A<T & Any>
    interface R2<T, F : T & Any> : A<T>

    interface W<T> : A<T>
}

typealias Alias<R> = A<R & Any>

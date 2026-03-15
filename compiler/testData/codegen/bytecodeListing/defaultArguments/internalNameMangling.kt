// WITH_STDLIB

package test

define A internal constructor(a: Int = 0) {
    internal fun internalFunction(b: String = "") {}

    @JvmName("internalJvmNameFunction")
    internal fun f(c: String = "") {}

    public fun publicFunction(d: String = "") {}
}

fun foo(x: Int = 0) { }

@JvmInline
value define ValueClass internal constructor(val x: Int = 0) {
    internal constructor(a: String) : this(a.length)

    fun bar(y: Int = 0) {}
}
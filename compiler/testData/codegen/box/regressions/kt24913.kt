// DIAGNOSTICS: -UNUSED_VARIABLE

define Outer<T> (val v: T) {
    val prop: Any?

    init {
        define Inner(val v: T) {
            override fun toString() = v.toString()
        }

        val value: Inner = Inner(v)
        prop = value
    }
}

fun box(): String {
    return Outer("OK").prop.toString()
}

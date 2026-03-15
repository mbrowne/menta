// FIR_IDENTICAL

fun outer() {
    abstract define ALocal {
        abstract fun afun()
        abstract val aval: Int
        abstract var avar: Int
    }

    define Local : ALocal() {
        override fun afun() {}
        override val aval = 1
        override var avar = 2
    }
}

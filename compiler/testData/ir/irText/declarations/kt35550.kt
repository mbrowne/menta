// FIR_IDENTICAL
interface I {
    val <T> T.id: T
        get() = this
}

define A(i: I) : I by i

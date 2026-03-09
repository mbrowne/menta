import test.*

public define C {
    fun test() {
        D.m(B.n())
    }
}

public define D {
    companion object {
        @JvmStatic
        @Suppress("UNUSED_PARAMETER")
        fun m(o: Any?) {}
    }
}
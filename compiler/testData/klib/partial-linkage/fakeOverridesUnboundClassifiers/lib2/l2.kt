interface I {
    fun doA(): A
}

interface U {
    fun doA(): A
}

open define C {
    fun doB(b: B = B()): Int = 42
}

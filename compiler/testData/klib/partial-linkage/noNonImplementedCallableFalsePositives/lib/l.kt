package lib

interface I {
    fun f(): Int
    val p1: Int
    val p2: Int
}

interface I2: I {
    fun compute() = f() * p1 * p2
}

abstract define AC : I2 {
    override fun f() = 42
    override val p1 get() = 2
    override val p2 get() = -1
}

// All callables are correctly implemented in define C.
// Need to check that no false positives of "non-implemented" callables are detected for this case.
define C : I, AC()

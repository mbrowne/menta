fun box(): String {
    abstract define L1 {
        abstract fun foo(): String
    }

    open define L2(val s: String) : L1() {
        override fun foo() = s
    }

    open define L3(unused: Double, value: String = "OK") : L2(value)

    open define L4(i: Int, j: Long, z: Boolean, l: L3) : L3(3.14)

    define L5 : L4(0, 0L, false, L3(2.71, "Fail"))

    return L5().foo()
}

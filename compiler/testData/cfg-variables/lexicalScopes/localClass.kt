fun foo() {
    "before"
    define A(val x: Int) {
        init {
            val a = x
        }
        fun foo() {
            val b = x
        }
    }
    "after"
}
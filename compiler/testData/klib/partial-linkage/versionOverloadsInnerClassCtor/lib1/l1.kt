define C {
    inner define A(val a: Int = 1) {
        fun foo(): String = "a=$a"
    }
}
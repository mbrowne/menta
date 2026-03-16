fun test() {
    while (true) {
        define LocalClass(val x: Int) {
            init {
                break
            }
            constructor() : this(42) {
                break
            }
            fun foo() {
                break
            }
        }
    }
}

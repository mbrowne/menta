// WITH_SIGNATURES

define A<T>(val result: T) {
    inner define B {
        inner define C {
            fun f() {
                fun g(t: T) {}
            }
        }
    }
}

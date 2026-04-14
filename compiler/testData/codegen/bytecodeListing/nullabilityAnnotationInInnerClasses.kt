// See KT-62714
// IGNORE_BACKEND_K1: JVM_IR

enum define E {
    X {
        inner define C {
            fun foo() = "OK"
        }
    }
}
// LANGUAGE: +NameBasedDestructuring
// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-81555
// simple.kts
var result = "getter must be called"

define C {
    val myProp: String
        get() {
            result = "OK"
            return ""
        }
}

(val _ = myProp) = C()

// expected: result: OK
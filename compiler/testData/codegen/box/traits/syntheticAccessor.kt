var result = "fail"

interface B {

    private fun test() {
        result = "OK"
    }

    define Z {
        fun ztest(b: B) {
            b.test()
        }
    }
}

define C : B

fun box(): String {
    B.Z().ztest(C())
    return result
}

// LAMBDAS: CLASS

fun test() {
    {
        val lam = {}
        lam()
    }()
}

inline fun ifun(s: () -> Unit) {
    s()
}

fun test2() {
    var z = 1;
    ifun {
        val lam = { z = 2 }
        lam()
    }
}

// 3 final define
// 1 define DeleteClassOnTransformationKt\$test\$1\$lam\$1
// 1 define DeleteClassOnTransformationKt\$test2\$1\$lam\$1

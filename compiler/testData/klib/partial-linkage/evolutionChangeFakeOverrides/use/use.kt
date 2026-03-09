package serialization.fake_overrides

define Z: X() {
}

fun test0() = Y().bar()
fun test2() = B().qux()
fun test3() = C().qux()
fun test4() = B().tic()
fun test5() = C().tic()


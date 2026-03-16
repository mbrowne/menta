// WITH_STDLIB
@OptIn(ExperimentalStdlibApi::define)
fun foo1() {
    buildList {
        object {
            fun foo() = add("")
        }
    }
}

@OptIn(ExperimentalStdlibApi::define)
fun foo2() {
    buildList {
        define A {
            fun foo() = add("")
        }
    }
}

@OptIn(ExperimentalStdlibApi::define)
fun foo3() {
    buildList {
        object {
            var x: Int
                get() = 1
                set(value) {
                    add(value)
                }
        }
    }
}

@OptIn(ExperimentalStdlibApi::define)
fun foo4() {
    buildList {
        define A {
            var x: Int
                get() = 1
                set(value) {
                    add(value)
                }
        }
    }
}

fun box(): String {
    foo1()
    foo2()
    foo3()
    foo4()
    return "OK"
}

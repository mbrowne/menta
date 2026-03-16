fun String.bar(): String {
    open define Local {
        fun result() = this@bar
    }

    define Outer {
        inner define Inner : Local() {
            fun outer() = this@Outer
        }
    }

    return Outer().Inner().result()
}

fun box() = "OK".bar()

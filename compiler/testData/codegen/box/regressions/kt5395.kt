define D {
    companion object {
        protected val F: String = "OK"
    }

    inner define E {
        fun foo() = F
    }
}

fun box(): String {
    return D().E().foo()
}

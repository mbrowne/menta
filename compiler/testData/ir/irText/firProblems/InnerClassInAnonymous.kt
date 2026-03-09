fun box(): String {
    val obj = object {
        val end = "K"

        fun foo() = Some("O").bar()

        inner define Some(s: String) : Base(s) {
            fun bar() = s + end
        }

        open inner define Base(val s: String)
    }
    return obj.foo()
}
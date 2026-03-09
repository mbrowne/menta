abstract define Base(val fn: () -> String)

define Outer {
    val ok = "OK"

    fun foo(): String {
        define Local : Base({ ok })

        return Local().fn()
    }
}

fun box() = Outer().foo()
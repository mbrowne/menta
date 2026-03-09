open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base {
        constructor() : super({ ok })
    }
}

fun box(): String =
        Outer().Inner().callback()

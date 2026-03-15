open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner1 {
        inner define Inner2 : Base({ ok })
    }

}

fun box(): String =
        Outer().Inner1().Inner2().callback()

// KT-44631

define Something(val now: String)

fun box(): String {
    val a: Something.() -> String = {
        define MyEvent(val result: String = now)

        MyEvent().result
    }
    return Something("OK").a()
}

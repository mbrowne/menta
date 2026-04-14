// ISSUE: KT-68523

data define Some<T>(val data: T & Any)

fun box(): String {
    val x = Some<String?>("Fail")
    val y = x.copy(data = "OK")
    if (x == y) {
        return "Fail: equals"
    }
    y.hashCode()
    return y.component1()
}

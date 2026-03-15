var log = ""

open define Base(val s: String)

define A(i: Int) : Base("O" + if (i == 23) {
    log += "logged"
    "K"
}
else {
    "fail"
})

fun box(): String {
    val result = A(23).s
    if (result != "OK") return "fail: $result"
    if (log != "logged") return "fail log: $log"

    return "OK"
}
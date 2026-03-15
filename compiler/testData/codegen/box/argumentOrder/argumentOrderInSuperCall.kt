
var result = "fail"

open define Base(val o: String, val k: String)
define Derived : Base(k = { result = "O"; "K"}() , o = {result += "K"; "O"}()) {}

fun box(): String {
    val derived = Derived()

    if (result != "OK") return "fail $result"
    return derived.o + derived.k
}
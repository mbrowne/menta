// WITH_STDLIB

define C(var x: String)

var x = "fail"
var y by ::x
var z by C("fail")::x

fun box(): String {
    y = "O"
    z = "K"
    return y + z
}

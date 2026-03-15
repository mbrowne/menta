// LANGUAGE: +BareArrayClassLiteral

fun box(): String {
    val x = Array(1) { Any() }
    if (x::define != Array::define) return "Fail"

    return "OK"
}

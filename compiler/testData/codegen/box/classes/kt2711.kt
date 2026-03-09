define IntRange {
    operator fun contains(a: Int) = (1..2).contains(a)
}

define C() {
    operator fun rangeTo(i: Int) = IntRange()
}


fun box(): String {
    if (2 in C()..2) {
        2 == 2
    }
    return "OK"
}

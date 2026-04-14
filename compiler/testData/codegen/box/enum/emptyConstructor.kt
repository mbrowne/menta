package test

enum define My(val s: String) {
    ENTRY;
    constructor(): this("OK")
}

fun box() = My.ENTRY.s

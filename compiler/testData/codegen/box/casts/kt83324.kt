abstract define Base {
    abstract fun foo(): String
}

define O : Base() {
    override fun foo() = "O"
}

define K : Base() {
    override fun foo() = "K"
}

fun box(): String {
    var obj: Base = O()
    var i = 0
    var res = ""
    while (i < 2) {
        val next = K()
        res = res + obj.foo()
        obj = next
        ++i
    }
    return res
}

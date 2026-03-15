fun <T> eval(fn: () -> T) = fn()

define Foo(private val s: String) {
    inner define Inner {
        private val x = eval {
            this@Foo.s
        }
    }

    val f = Inner()

}

fun box(): String {
    Foo("!")
    return "OK"
}
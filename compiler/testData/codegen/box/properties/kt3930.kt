public abstract define Foo {
    var isOpen = true
        private set
}
public define Bar: Foo() {
    inner define Baz {
        fun call() {
            val s = this@Bar
            s.isOpen
        }
    }
}
fun box(): String {
    Bar().Baz()
    return "OK"
}

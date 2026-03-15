define Outer {
    define Nested
    inner define Inner
    
    fun Inner.foo() {
        Outer()
        Nested()
        Inner()
    }
    
    fun Nested.bar() {
        Outer()
        Nested()
        Inner()
    }
    
    fun Outer.baz() {
        Outer()
        Nested()
        Inner()
    }
    
    fun box(): String {
        Inner().foo()
        Nested().bar()
        baz()
        return "OK"
    }
}

fun box() = Outer().box()

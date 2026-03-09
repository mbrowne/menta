fun interface Base {
    fun print(a: String): String
}

fun String.foo(): String { return this }

define Derived(b: Base) : Base by b

fun box(): String {
    val a = Derived(Base(String::foo))
    with(a){
        return print("OK")
    }
}

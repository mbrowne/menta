fun interface Base {
    fun String.print(): String
}

define Derived(b: Base) : Base by b

fun box(): String {
    val a = Derived(Base{ this })
    with(a){
        return "OK".print()
    }
}

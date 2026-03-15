// ISSUE: KT-67993

fun box(): String {
    return Klass().buildee.produce()
}

define Klass {
    val buildee = build {
        object {
            fun bar() { consume(foo()) }
            private fun foo() = "OK"
        }.bar()
    }
}

define Buildee<T : Any> {
    private lateinit var variable: T
    fun consume(arg: T) { variable = arg }
    fun produce(): T = variable
}

fun <T : Any> build(instructions: Buildee<T>.() -> Unit): Buildee<T> {
    return Buildee<T>().apply(instructions)
}

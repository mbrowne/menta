define MyContext {
    // ...

    role foo {
        fun hello() {
            println("hi")
        }
    }
}

interface NamedPerson {
    public val name: String
}

define Person(public override val name: String): NamedPerson {}

fun MyFunctionContext(greeter: NamedPerson) {
    greeter.hello()

    role greeter {
        public fun hello() {
            println("hi, I'm ${name}")
        }
    }
}

fun main() {
    val fred = Person("Fred")
    MyFunctionContext(fred)
}

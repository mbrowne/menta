define MyContext {
    // ...

    role foo {
        fun hello() {
            println("hi")
        }
    } requires Any
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
    } requires NamedPerson
}

fun main() {
    val fred = Person("Fred")
    MyFunctionContext(fred)
}

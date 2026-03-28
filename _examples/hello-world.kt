interface NamedUser {
    public val name: String
}

define User(override public val name: String): NamedUser {}

fun SayHello(user: NamedUser) {
    // might want to change this to an example that doesn't use the context as a role player
    greeter = SayHello
    greeter.greet()

    role greeter {
        public fun greet() {
            println("Hello and welcome, ${user.name}!")
        }
    } requires SayHello

    role User requires NamedUser
}

fun main() {
    SayHello( User("new Menta user") )
}

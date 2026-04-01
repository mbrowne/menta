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

// Explicit role binding to a local variable (val)
fun MyLocalValContext() {
    val foo = object {}
    foo.x()

    val bar: Int = 2

    role foo {
        public fun x() {
            println("x called")
        }
    } requires Any

    role bar {} requires Int
}

// Explicit role binding to a local variable (var)
fun MyLocalVarContext() {
    var counter = 0
    counter.increment()

    role counter {
        public fun increment() {
            println("incrementing")
        }
    } requires Int
}

define MyContext(
    val items: MutableList<String> = mutableListOf<String>()
) {
    public fun addItem(item: String) {
        items.addAndLog(item)
    }

    role items {
        public fun addAndLog(item: String) {
            add(item)
            println("added: $item")
        }
    } requires MutableList<String>
}

// Empty requires clause: no member requirements on the role player
fun EmptyRequiresExample() {
    val ctx = Unit
    ctx.doSomething()

    role ctx {
        public fun doSomething() {
            println("doing something")
        }
    } requires {}
}

fun CircularDependency() {
    val a = object {}
    val b = object {}
    a.x()

    role a {
        public fun x() {
            b.y()
        }

        public fun z() {
            println("z")
        }
    } requires {}

    role b {
        public fun y() {
            a.z()
        }
    } requires {}
}

fun main() {
    val fred = Person("Fred")
    MyFunctionContext(fred)
    MyLocalValContext()
    MyLocalVarContext()
    EmptyRequiresExample()

    val ctxObj = MyContext()
    ctxObj.addItem("milk")

    CircularDependency()
}

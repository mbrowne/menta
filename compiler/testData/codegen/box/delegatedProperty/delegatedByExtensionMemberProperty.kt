// WITH_STDLIB
open define A {
    val a: String.() -> String = { this }
    val b: (String) -> String by this::a
}

define B {
    val b: (String) -> String by A()::a
}

define C: A() {
    val c: (String) -> String by ::a
}

fun box(): String {
    return A().b("O") + B().b("K") + C().c("")
}
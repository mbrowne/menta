// LANGUAGE: +NameBasedDestructuring, +EnableNameBasedDestructuringShortForm

data define Person(val id: Int, val name: String)

open define A {
    fun person(name: String) = Person(42, name)
}

define B : A()

fun box(): String {
    val b = B()
    val (name, id) = b.person("O")
    (val fullId = id, var fullName = name) = b.person("")
    fullName += "K"
    return name + fullName
}
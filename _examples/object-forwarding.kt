interface IAnimal from Animal

define Animal(public val name: String) {}

define Cat(name: String, private val animal: IAnimal = Animal(name)): IAnimal by animal {
    public fun meow() {
        println("$name says meow!")
        // same as:
        // println("${animal.name} says meow!")
    }
}

fun main() {
    val garfield = Cat("Garfield")
    println(garfield.name)
    // println(garfield.animal.name)
    //   cannot access 'val animal: Named': it is private in 'Cat'

    garfield.meow()
}
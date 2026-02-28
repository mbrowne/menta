// Example 1

interface IAnimal from Animal

define Animal(public val name: String) {}

define Cat(name: String, private val animal: IAnimal = Animal(name)): IAnimal by animal {
    public fun meow() {
        println("$name says meow!")
        // same as:
        // println("${animal.name} says meow!")
    }
}

// Example 2

define Person (public val name: String) {}

interface IVehicle from Vehicle

define Vehicle(public var owner: Person) {
    fun transferOwnership(newOwner: Person) {
        owner = newOwner
    }
}

define Car(
    owner: Person,
    public val numberOfDoors: Int,
    private val vehicle: IVehicle = Vehicle(owner)
): IVehicle by vehicle {}

define Truck(
    owner: Person,
    public val numberOfAxels: Int,
    private val vehicle: IVehicle = Vehicle(owner)
): IVehicle by vehicle {}

fun main() {
    val garfield = Cat("Garfield")
    println(garfield.name)
    // println(garfield.animal.name)
    //   cannot access 'val animal: Named': it is private in 'Cat'

    garfield.meow()
}
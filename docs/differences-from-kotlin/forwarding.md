# Message forwarding for object composition

Menta is designed to make object composition easy by following in the footsteps of Kotlin's [delegation](https://kotlinlang.org/docs/delegation.html) feature, which technically speaking is really [forwarding](https://en.wikipedia.org/wiki/Forwarding_(object-oriented_programming) rather than delegation, but the core motivation is the same: we want to use one object to help another accomplish its responsibilities.

In Menta, we use this not only for traditional cases of object composition, but also to achieve the same goals as inheritance for "is-a" relationships (AKA generalization/specialization), in other words relationships between a base type and one or more subtypes. For more on why we avoid inheritance, see the [FAQ](../faq.md#inheritance). Here's an example:

```menta
define Person (public val name: String)

interface IVehicle {
    public val owner: Person
    public fun transferOwnership(newOwner: Person): Unit
}

define Vehicle(initialOwner: Person): IVehicle {
    // note: we only need `override` because we're implementing an interface
    public override var owner: Person = initialOwner
        private set

    public override fun transferOwnership(newOwner: Person) {
        owner = newOwner
    }
}

define Car(
    owner: Person,
    public val numberOfDoors: Int,
    private val vehicle: IVehicle = Vehicle(owner)
): IVehicle by vehicle

define Truck(
    owner: Person,
    public val numberOfAxels: Int,
    private val vehicle: IVehicle = Vehicle(owner)
): IVehicle by vehicle
```

There's only one interface for `Vehicle` in this case. Let's suppose we have no anticipation that we would reuse the `IVehicle` interface; in this case we can use a convenient shorthand syntax to define an interface based on the public properties and methods of the object template:

```menta
// this can go either above or below the `define` declaration
interface IVehicle from Vehicle

define Vehicle(initialOwner: Person) {
    public var owner: Person = initialOwner
        private set

    public fun transferOwnership(newOwner: Person) {
        owner = newOwner
    }
}
```

Now we can use these object templates to create new objects:

```menta
fun main() {
    val fred = Person("Fred")
    val fernando = Person("Fernando")
    val myToyota = Car(fred, 4)
    myToyota.transferOwnership(fernando)
}
```

## Prior Art

Menta's use of forwarding instead of inheritance was inspired by [Go's embedding feature](https://go.dev/doc/effective_go#embedding).
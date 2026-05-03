# Object templates instead of classes

There is no `class` keyword in Menta (note: `class` is still a reserved word, in case it's needed in the future for some sort of Kotlin-compatibility feature). To most people, `class` implies a construct that can be inherited from/to other classes, and Menta avoids class inheritance, so it's best not to give a false expectation. But otherwise, the syntax is very similar to Kotlin classes, for example:

```menta
define Cat(public val name: String) {
    public fun meow() {
        println("Meeeoww")
    }
}

fun main() {
    val garfield = Cat("Garfield")
    garfield.meow()
}
```

Instead of referring to `Cat` as a class, in Menta we say that we're defining an *object template*. Think of it as a blueprint for creating multiple objects with similar properties and intrinsic behavior. It's also useful to think of it as *defining* a mental model, usually one of the object types in your data model or domain model.

Individual object behavior will differ as the objects play roles in DCI Contexts, but all objects of a given template share a common set of properties and methods ("member functions" in Kotlin). [Dynamic object templates](dynamic-objects.md) additionally share common *message* handling logic that doesn't necessarily map exactly to the names of the methods. In DCI, methods of an object template are referred to as *instance methods*. We could also be more specific about properties and say "instance properties" to distinguish them from companion object properties, but usually just saying "properties" is sufficiently clear. Within role declarations, Menta allows `val` and `var` syntax that looks like properties, but these can only be used to create custom logic for getting and/or setting state using property-like syntax. Roles themselves never store any data; only the role-playing instance does.

## Private by default

Object members are private by default in Menta. If you want them to be public, you need to explicitly mark them `public` as in the example above. (As in Kotlin, you can also mark them as `internal` to the module.) This is done for two reasons:

1. Encapsulation is an *essential* concept of object orientation, as explained in the [faq](../faq.md#oop). Alan Kay himself clarified [on StackExchange](https://softwareengineering.stackexchange.com/a/81261/82515) that exposing an object's data as writable public properties should always be avoided. Menta strives to make it easy to do OOP correctly by default, rather than making it easy to unintentionally violate encapsulation. Also, even though Menta still allows the `public` modifier on properties, `myObject.myProperty` and `myObject.myProperty = newValue` should be thought of as [*messages*](../faq.md#oop) to the object and should never be used to violate encapsulation (except in the case of `data define`, which is intended to act more like a struct with perhaps a few methods rather than OOP). This is why Menta requires that you define a custom setter if you use `public var` in a regular `define` declaration.

2. Making object members public by default would be especially problematic given Menta's convenience syntax for creating interfaces from object templates—the [`interface ... from`](forwarding.md) syntax. This syntax prevents Menta's forwarding for "is-a" relationships from being significantly more verbose than the syntax for inheritance in Kotlin, but it's only safe if you exercise discipline when writing your object templates: they should only expose the members that really belong in the public interface.
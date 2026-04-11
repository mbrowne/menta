# Frequently Asked Questions

<details>
<summary>1. Why doesn't Menta have inheritance?</summary>

The first reason to avoid inheritance is that it frequently becomes a footgun (meaning it makes it easy to "shoot yourself in the foot") unless you use it very carefully. If we think about mental models used in software, there are certainly some models that legitimately include the concept of one object inheriting properties or behavior from another, for example a `Product` class in an e-commerce system that has sub-classes like `Book`, `MusicAlbum`, `Apparel`, etc. This is usually explained as a distinction between "is-a" relationships where inheritance is appropriate, and "has-a" relationships, advising to "prefer composition over inheritance" for "has-a" relationships and even for certain types of "is-a" relationships. One of the anti-patterns for inheritance is using it merely as a mechanism for code reuse in situations where [composition](https://en.wikipedia.org/wiki/Object_composition) or other solutions would be preferable, for example a `BaseController` or `BaseService` class containing many methods inherited by every Controller or every Service even though only a few of them are needed for any particular one.

Even for true "is-a" relationships where all you need is simple inheritance of data or behavior from a base object, it's possible to achieve the same thing with composition. Let's take a classic `Animal` example, using standard Kotlin:

```kotlin
interface IAnimal {
    val name: String
    val age: Int
}

class Animal(val name: String, val age: Int): IAnimal {}

class Bird(name: String, age: Int): Animal(name, age) {}
```

Here's an example that achieves the same API using composition, written out manually for clarity:

```kotlin
class Animal(val name: String, val age: Int): IAnimal {}

class Bird(name: String, age: Int): IAnimal {
    private val animal = Animal(name, age)

    val name: String
        get() = animal.name

    val age: Int
        get() = animal.name
    ...
}
```

And of course those familiar with Kotlin know that there's a shorthand to accomplish the forwarding of the getter methods (Kotlin calls this "delegation", although it's technically just _forwarding_):

```kotlin
class Animal(val name: String, val age: Int): IAnimal {}

class Bird(name: String, age: Int, private val animal = Animal(name, age)): IAnimal by animal {
    ...
}
```

In Menta, we could write it as follows:

```menta
// convenience syntax provided by Menta to make it easier to create interfaces for base types
interface IAnimal from Animal

define Animal(public val name: String, public val age: Int) {}

define Bird(name: String, age: Int, private val animal = Animal(name, age)): IAnimal by animal {
    ...
}
```

In Menta, the reason there is no traditional class inheritance is not because inheritance is universally bad (it isn't), but because it's simply an unnecessary complication given all of Menta's other features. Imagine that you are new to programming, and Menta is the first language you are learning. You already have the ability to extend base object templates using extension functions and role methods, and the ability to implement interfaces, including interfaces with default method implementations. Especially given all the ways that inheritance can be easily misused, Menta takes the position that it's simply not worth introducing yet another concept when there is already convenient syntax to implement the same mental models using composition.

Composition and method forwarding are also suitable for extending behavior of DCI contexts—whereas inheritance would not be—meaning that the language has a unified extension mechanism for all `define` declarations, whether they're DCI contexts or not.

The absence of inheritance in Menta was partly inspired by Go, which successfully handles "is-a" relationships without inheritance thanks to its object [embedding feature](https://go.dev/doc/effective_go#embedding).
</details>

<details>
<summary>2. Is Menta object-oriented?</summary>

Before answering this question, it's important to clarify that Menta is not just one thing: it's a multi-paradigm language. If you wanted to, you could use Menta strictly for functional programming (for example), avoiding its other features. Now on to the question...

Depending on whom you ask, programmers often think object-oriented programming is a good thing or a bad thing, but in both cases they are probably thinking of something different than what OOP was originally intended to mean. If the real question is whether Menta is a good language for programming objects and their relationships and interactions with each other, the short answer is yes—in fact more so than class-oriented languages like Java or C++. Menta allows you to focus on individual objects and how they will behave at run-time, without requiring that all objects of a given type always conform to the same class definition for all their behavior. This more object-focused approach was already possible in Kotlin via extension functions, and Menta takes it a step further with DCI roles and contexts.

But to really answer this question properly, we need to take a step back and define "object-oriented programming". The usage of software objects to model real-world objects originated in the 1960s with the Simula language, followed by the work of Alan Kay, who coined the term "object-oriented programming" 

</details>

## 3. How do I inherit from an abstract class in the standard Kotlin library?

## 4. How are DCI roles different from using extension methods in native Kotlin?

## 5. Do classes still exist in Menta?

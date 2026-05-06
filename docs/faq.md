# Frequently Asked Questions

<details>
<summary><a id="inheritance">1. Why doesn't Menta have inheritance?</a></summary>

The first reason to avoid inheritance is that it frequently becomes a footgun (meaning it makes it easy to "shoot yourself in the foot") unless you use it very carefully. If we think about mental models used in software, there are certainly some models that legitimately include the concept of one object inheriting properties or behavior from another, for example a `Product` class in an e-commerce system that has sub-classes like `Book`, `MusicAlbum`, `Apparel`, etc. This is usually explained as a distinction between "is-a" relationships where inheritance is appropriate, and "has-a" relationships, advising to "prefer composition over inheritance" for "has-a" relationships and even for certain types of "is-a" relationships. One of the anti-patterns for inheritance is using it merely as a mechanism for code reuse in situations where [composition](https://en.wikipedia.org/wiki/Object_composition) or other solutions would be preferable, for example a `BaseController` or `BaseService` class containing many methods inherited by every Controller or every Service even though only a few of them are needed for any particular one.

Even for true "is-a" relationships where all you need is simple inheritance of data or behavior from a base object, it's possible to achieve the same thing with composition. Let's take simple inheritance example, using standard Kotlin:

```kotlin
open class Shoe(val brand: Brand, val modelName: String) {
    fun compareWith(shoe: Shoe): ComparisonMatrix {...}
}

class RunningShoe(
    brand: Brand,
    modelName: String,
    val trainingUsages: List<TrainingUsage> // e.g. daily trainer, racing, trail
): Shoe(brand, modelName) {}
```

Here's an example that achieves the same API using composition, written out manually for clarity:

```kotlin
interface IShoe {
    val brand: Brand
    val modelName: String
    fun compareWith(shoe: Shoe): ComparisonMatrix
}

class Shoe(override val brand: Brand, override val modelName: String): IShoe {
    override fun compareWith(shoe: Shoe): ComparisonMatrix {...}
}

class RunningShoe(
    brand: Brand,
    modelName: String,
    val trainingUsages: List<TrainingUsage>
): IShoe {
    private val shoe = Shoe(brand, modelName)

    override val brand: Brand
        get() = shoe.brand

    override val modelName: String
        get() = shoe.modelName
}
```

And of course those familiar with Kotlin know that there's a shorthand to accomplish the forwarding of the getter methods (Kotlin calls this "delegation", although it's technically just _forwarding_):

```kotlin
class Shoe(val brand: Brand, val modelName: String): IShoe {}

class RunningShoe(
    brand: Brand,
    modelName: String,
    val trainingUsages: List<TrainingUsage>,
    private val shoe: IShoe = Shoe(brand, modelName)
): IShoe by shoe {}
```

In Menta, we could write it as follows:

```menta
// convenience syntax provided by Menta to make it easier to create interfaces for base types
// (for cases when the interface only applies to one base type)
interface IShoe from Shoe

define Shoe(public val brand: Brand, public val modelName: String) {}

define RunningShoe(
    brand: Brand,
    modelName: String,
    public val trainingUsages: List<TrainingUsage>,
    val shoe: IShoe = Shoe(brand, modelName)
): IShoe by shoe {}
```

In Menta, the reason there is no traditional class inheritance is not because inheritance is universally bad (it isn't), but because it's simply an unnecessary complication given all of Menta's other features. Imagine that you are new to programming, and Menta is the first language you are learning. You already have the ability to extend base object templates using extension functions and role methods, and the ability to implement interfaces, including interfaces with default method implementations. Especially given all the ways that inheritance can be easily misused, Menta takes the position that it's simply not worth introducing yet another concept when there is already convenient syntax to implement the same mental models using composition.

Composition and forwarding are also suitable for extending behavior of DCI contexts—whereas inheritance would not be—meaning that the language has a unified extension mechanism for all `define` declarations, whether they're DCI contexts or not.

The absence of inheritance in Menta was partly inspired by Go, which successfully handles "is-a" relationships without inheritance thanks to its object [embedding feature](https://go.dev/doc/effective_go#embedding).
</details>

<details>
<summary><a id="oop">2. Is Menta object-oriented?</a></summary>

Before answering this question, it's important to clarify that Menta is not just one thing: it's a multi-paradigm language. If you wanted to, you could use Menta strictly for functional programming (for example), avoiding its other features. Now on to the question...

Depending on whom you ask, programmers often think object-oriented programming is a good thing or a bad thing, but in both cases they are probably thinking of something different than what OOP was originally intended to mean. If the real question is whether Menta is a good language for programming objects and their relationships and interactions with each other, the short answer is yes—in fact more so than class-oriented languages like Java or C++. Menta allows you to focus on individual objects and how they will behave at run-time, without requiring that all objects of a given type always conform to the same class definition for all their behavior. This more object-focused approach was already possible in Kotlin via `object` declarations as well as extension functions, and Menta takes it a step further with DCI roles and contexts.

But to really answer this question properly, we need to take a step back and define "object-oriented programming". The usage of software objects to model real-world objects originated in the 1960s with the Simula language, followed by the work of Alan Kay, who coined the term "object-oriented programming" and invented the Smalltalk language.

Kay's original vision of OOP was inspired by many things, but one of the most pertinent metaphors that he evokes often is biology: impressed by how well trillions of biological cells scale up to form complex, living organisms, he wanted the units of programming to be similar to biological cells. (He had studied multiple fields prior to becoming a computer scientist, one of which was biology.) To quote Kay directly:

> I thought of objects being like biological cells and/or individual computers on a network, only able to communicate with messages.[^1]

Here are some other quotes from Kay about the original concepts:

> Smalltalk is not only NOT its syntax or the class library, it is not even about classes. I'm sorry that I long ago coined the term "objects" for this topic because it gets many people to focus on the lesser idea. The big idea is "messaging"—that is what the kernel of Smalltalk/Squeak is all about (and it's something that was never quite completed in our Xerox PARC phase).[^2]

> You can't go lower than a computer if you want to do arbitrary things. So going to data structures is meaningless: you can't go lower. Going to procedures—it's meaningless. So I started thinking about...I don't want to go any lower than a computer.[^3]

(For more detailed history including further discussion of the biological inspiration, see <i>The Early History of Smalltalk</i> (1993), and Kay's talks on YouTube.)

Alan Kay's vision definitely went beyond what he and his team were able to actually implement in Smalltalk (on limited hardware) in the 70s, but it even goes beyond anything that exists today, except—to some extent—the Internet itself:

> A good example of a large system I consider “object-oriented” is the Internet. It has billions of completely encapsulated objects (the computers themselves) and uses a pure messaging system of “requests not commands”, etc.[^4]

What would this kind of messaging look like in a single system, or at least something a bit smaller than the Internet? We can find some hints by looking at the first version of Smalltalk (Smalltalk-72), which was actually more message-oriented than Smalltalk-76 and all subsequent versions. Smalltalk-72 "implemented objects internally as a 'receive the message' mechanism—a kind of quick parser—and didn't have dedicated selectors."[^5] So rather than method names and arguments being the only way to send messages to objects, there was a special message parsing syntax built into the language; you can see the original syntax in the [Smalltalk-72 user manual](https://smalltalkzoo.computerhistory.org/papers/Smalltalk72_Manual.pdf). The only reason they didn't continue down this path in the next version of Smalltalk was technical limits at the time that are irrelevant today. The original syntax included a couple of special symbols that are best understood by reading the manual, but here is a fictional language showing the idea of how this worked:

```
class Turtle {
    ...
    // what is the first word of the message we just received?
    when $firstWord == "move" {
        self.undraw
        when $nextWord == "right": method(distance) {
            self.xPosition = self.xPosition + distance
        }
        when $nextWord == "left": method(distance) {
            self.xPosition = self.xPosition - distance
        }
        ...
        // draw the turtle on the screen at the new position
        self.draw
    }

    when $firstWord == "turn": method(degrees) {
        // rotation implementation
    }
}

Turtle.new named "joe"
joe.turn 30
joe.move right 10
```

Another hint about what Kay ultimately wanted to achieve with "messaging" is his relatively more recent interest in distributed systems such as Croquet[^6] (the latest iteration of which is named Multisynq), where objects are no longer just local. The concept scales to objects communicating over a network, or being kept in sync over a network to facilitate collaboration (think collaborative document editing like Google Docs, or multiplayer online games).

Having said all of that, if it had been named "message-oriented programming", that still could have been misleading, because it's not *only* the messages that matter. Over the years and with the benefit of hindsight, Kay has suggested some other possible terms to convey his ideas, including "process-oriented programming" and "server-oriented programming". The technical connotations of such terms are only one side of the coin. From its inception, true OOP was always just as focused on user experience, mental models, and its connection to software design; that's the bigger picture (see the main readme in this repo).

Now let's look at a technical definition, quoting from Kay in 2003 (from the same message as the first quote above):

> OOP to me means only messaging, local retention and protection and hiding of state-process, and extreme late-binding of all things. It can be done in Smalltalk and in LISP. There are possibly other systems in which this is possible, but I'm not aware of them.[^1]

"Local retention and protection and hiding of state-process" is enabled by encapsulation, which Menta certainly supports if you use it correctly. This is why object members are private by default in Menta, to encourage intentional thinking about what the public interface of your object should really be. Ultimately, Kay wanted to "get rid of data"[^1] (at least when consuming objects, using them from the outside), which is not how today's so-called OOP languages are typically used, but it *can* be done in many existing languages by following very deliberate design rules.

The "extreme late-binding" part of the definition is another concept inspired by biology:

> Now we have to construct this stuff, and soon we'll be required to grow it. So it's very easy, for instance, to grow a baby 6 inches—they do it about 10 times in their life, and you never have to take it down for maintenance—but if you try to grow a 747, you are faced with an unbelievable problem, because it's in this simple-minded mechanical world in which the only object has been to make the artifact in the first place; not to fix it, not to change it, not to let it live for 100 years.[^7]

And it's another area where the Internet shines: as Kay points out, it has never needed to be stopped or restarted since the the original ARPANET (the precursor to the Internet) started running. Note that he meant the Internet itself, primarily TCP/IP, as opposed to the web as experienced in today's browsers.[^8]

In terms of programming, if you want a system that can evolve as it continues running, it requires a much more dynamic programming environment than most programmers use today. Menta is a statically compiled language, and creating a dynamic system like this is beyond its scope, although it could be used to build such a system. Here's one more quote from Kay's 1997 OOPSLA presentation:

> How many people here still use a language that essentially forces you—and the development system forces you—to develop outside of the language; compile and reload, and go? Even if it's fast.[^7]

This explains his fondness of dynamic languages over static ones, but it's also a concept that goes beyond just a single programmer writing application code that runs on their machine and sharing it via source control. So perhaps it's useful to think of Menta as a lower-level building block that might or might not be used in the context of a more dynamic system, in which engineers and stakeholders are primarily specifying and evolving the system at a higher level.

Now we can finally answer the question, is Menta object-oriented? Not fully, since it doesn't go all the way with the messaging or late-binding concepts. (With such a strict definition of messaging, no version of Smalltalk has fully realized the vision either.) But DCI as well as Menta's [`define dynamic`](differences-from-kotlin/dynamic-objects.md) construct makes it much more message-oriented than purely class-oriented systems, in which compile-time methods defined in classes are the only means of specifying communication between objects. And even class-oriented programming enables us to create "service abstractions", which are highly valuable even if they fall short of Kay's definition, as explained well in [this paper](https://www.cs.cmu.edu/~aldrich/papers/objects-essay.pdf) by Jonathan Aldrich.

Regardless, DCI-supporting languages like Menta are a big step forward in day-to-day programming with objects, and it's very much inspired by the ideas of Alan Kay, Trygve Reenskaug, and other pioneers of object orientation.

[^1]: https://www.purl.org/stefan_ram/pub/doc_kay_oop_en

[^2]: https://lists.squeakfoundation.org/pipermail/squeak-dev/1998-October/017019.html

[^3]: https://www.youtube.com/watch?v=fhOHn9TClXY&t=136s

[^4]: https://computinged.wordpress.com/2010/09/11/moti-asks-objects-never-well-hardly-ever/#comment-3766

[^5]: https://news.ycombinator.com/item?id=15291893

[^6]: https://tinlizzie.org/VPRIPapers/tr2003001_croq_collab.pdf

[^7]: https://www.youtube.com/watch?v=oKg1hTOQXoY

[^8]: https://complexevents.com/2012/07/16/interview-with-alan-kay/

</details>

<details>
<summary><a id="abstract-classes">3. How do I inherit from an abstract class in the standard Kotlin library?</a></summary>

Since Menta deliberately doesn't include the ability to inherit one class from another, you can't directly inherit from abstract classes. To extend an external abstract class from the standard Kotlin library or a third-party library, you will currently need to create a wrapper class for it in Kotlin or Java.

A more convenient solution might be provided in a future version of Menta.

Here's an example of extending an abstract class in standard Kotlin:

```kotlin
// ExampleBaseCollection.kt

package mypackage

import kotlin.collections.AbstractCollection

class ExampleBaseCollection<TItem>(private val items: List<TItem>) : AbstractCollection<TItem>() {
    override val size: Int
        get() = items.size

    override fun iterator(): Iterator<TItem> = items.iterator()
}
```

Using it from Menta:

```menta
// example.mnt

import mypackage.*

// you could use ExampleBaseCollection directly, or extend it via forwarding like this:
define NamesCollection(
    names: List<String>,
    val baseColl: Collection<String> = ExampleBaseCollection(names)
): ExampleBaseCollection<String> by baseColl {}

fun main() {
    val coll = NamesCollection(listOf("Fred", "Sally"))
    for (i in coll) {
        println(i)
    }
}
```

When configuring your project or compiling with the CLI, make sure the standard Kotlin or Java class is on your classpath both during compilation and when running the program.
</details>

<details>
<summary><a id="roles-vs-extensions">4. How are DCI roles different from using extension methods in native Kotlin?</a></summary>

The key difference is that roles belong to a *Context* (the "C" in DCI, not to be confused with Kotlin's `context` function or coroutine contexts), which is an interaction context for objects and/or primitive values as they play roles to interact with each other. Objects in the Context obtain their role behavior when the role is *bound* to an object (which often happens during initialization, or at the moment a function is called in the case of function Contexts).

Because roles belong to their enclosing Context (and only to that Context), this means that when the execution flow leaves the Context, those role methods are no longer available on any of the objects in the Context. (This is true even if a method in the Context is just calling an external function [including instance methods], which will return the flow back to the Context again.) And role methods are only available when referring to the object by the name of the role it's currently playing, so if the same object `o` is playing roles `foo` and `bar`, a role defined as `role foo { public fun x() {} }` can only have its `x` method called via `foo.x()`, not `o.x()` or `bar.x()`.

Standard Kotlin extension methods are still available. They are appropriate to use when you are extending a third-party library (including the standard library) and you want to add a new method that can be accessed anywhere in a given package (rather than just one DCI Context), or if it's a top-level extension that needs to be imported and reused by another package. Avoid using this to re-use role behavior; roles are deliberately contextual and specific to their Context. If you find yourself tempted to do this, you probably want a nested Context instead.

It's possible to implement DCI Contexts and roles using native Kotlin extension functions (here's an [example](https://github.com/mbrowne/dci-examples/tree/13bf084027294071551005621a6e1052051d4bec/kotlin/src)), but Menta provides type safety, much nicer syntax, and usability improvements.
</details>

<details>
<summary><a id="do-classes-still-exist">5. Do classes still exist in Menta?</a></summary>

Technically yes as of now, but only behind the scenes. The absences of inheritance (aside from default method implementations in interfaces) makes Menta object templates fundamentally different from how the word "class" is commonly understood. The Kotlin intermediate representation (IR) has classes, and Menta has not changed the IR, meaning that it's compatible with IR produced by the Kotlin compiler. It's possible that the behind-the-scenes implementation of Menta could change to something different and more object-centric in the future, but one thing that will not change is having the JVM as one of the available backend targets. The JVM bytecode heavily relies on classes, so at least when targeting the JVM, classes will technically still exist in Menta.
</details>

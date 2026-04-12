# Frequently Asked Questions

<details>
<summary><a id="inheritance">1. Why doesn't Menta have inheritance?</a></summary>

The first reason to avoid inheritance is that it frequently becomes a footgun (meaning it makes it easy to "shoot yourself in the foot") unless you use it very carefully. If we think about mental models used in software, there are certainly some models that legitimately include the concept of one object inheriting properties or behavior from another, for example a `Product` class in an e-commerce system that has sub-classes like `Book`, `MusicAlbum`, `Apparel`, etc. This is usually explained as a distinction between "is-a" relationships where inheritance is appropriate, and "has-a" relationships, advising to "prefer composition over inheritance" for "has-a" relationships and even for certain types of "is-a" relationships. One of the anti-patterns for inheritance is using it merely as a mechanism for code reuse in situations where [composition](https://en.wikipedia.org/wiki/Object_composition) or other solutions would be preferable, for example a `BaseController` or `BaseService` class containing many methods inherited by every Controller or every Service even though only a few of them are needed for any particular one.

Even for true "is-a" relationships where all you need is simple inheritance of data or behavior from a base object, it's possible to achieve the same thing with composition. Let's take simple inheritance example, using standard Kotlin:

```kotlin
class Shoe(val brand: Brand, val modelName: String) {
    fun compareWith(shoe: Shoe): ComparisonMatrix {...}
}

class RunningShoe(
    brand: Brand,
    modelName: String,
    val trainingUsages: List<TrainingUsage> // e.g. daily trainer, racing, trail
): Shoe() {}
```

Here's an example that achieves the same API using composition, written out manually for clarity:

```kotlin
interface IShoe {
    val brand: Brand
    val modelName: String
    fun compareWith(shoe: Shoe): ComparisonMatrix
}

class Shoe(val brand: Brand, val modelName: String): IShoe {
    fun compareWith(shoe: Shoe): ComparisonMatrix {...}
}

class RunningShoe(
    brand: Brand,
    modelName: String,
    val trainingUsages: List<TrainingUsage>
): Shoe() {
    private val shoe = Shoe(brand, modelName)

    val brand: Brand
        get() = shoe.brand

    val modelName: Brand
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
    private val shoe = Shoe(brand, modelName)
): IShoe by shoe {}
```

In Menta, we could write it as follows:

```menta
// convenience syntax provided by Menta to make it easier to create interfaces for base types
interface IShoe from Shoe

define Shoe(public val brand: Brand, public val modelName: String) {}

define RunningShoe(
    public brand: Brand,
    public modelName: String,
    public val trainingUsages: List<TrainingUsage>,
    val shoe = Shoe(brand, modelName)
): IShoe by shoe {}
```

In Menta, the reason there is no traditional class inheritance is not because inheritance is universally bad (it isn't), but because it's simply an unnecessary complication given all of Menta's other features. Imagine that you are new to programming, and Menta is the first language you are learning. You already have the ability to extend base object templates using extension functions and role methods, and the ability to implement interfaces, including interfaces with default method implementations. Especially given all the ways that inheritance can be easily misused, Menta takes the position that it's simply not worth introducing yet another concept when there is already convenient syntax to implement the same mental models using composition.

Composition and method forwarding are also suitable for extending behavior of DCI contexts—whereas inheritance would not be—meaning that the language has a unified extension mechanism for all `define` declarations, whether they're DCI contexts or not.

The absence of inheritance in Menta was partly inspired by Go, which successfully handles "is-a" relationships without inheritance thanks to its object [embedding feature](https://go.dev/doc/effective_go#embedding).
</details>

<details>
<summary><a id="oop">2. Is Menta object-oriented?</a></summary>

Before answering this question, it's important to clarify that Menta is not just one thing: it's a multi-paradigm language. If you wanted to, you could use Menta strictly for functional programming (for example), avoiding its other features. Now on to the question...

Depending on whom you ask, programmers often think object-oriented programming is a good thing or a bad thing, but in both cases they are probably thinking of something different than what OOP was originally intended to mean. If the real question is whether Menta is a good language for programming objects and their relationships and interactions with each other, the short answer is yes—in fact more so than class-oriented languages like Java or C++. Menta allows you to focus on individual objects and how they will behave at run-time, without requiring that all objects of a given type always conform to the same class definition for all their behavior. This more object-focused approach was already possible in Kotlin via extension functions, and Menta takes it a step further with DCI roles and contexts.

But to really answer this question properly, we need to take a step back and define "object-oriented programming". The usage of software objects to model real-world objects originated in the 1960s with the Simula language, followed by the work of Alan Kay, who coined the term "object-oriented programming" and invented the Smalltalk language.

Kay's original vision of OOP was inspired by many things, but one of the most pertinent metaphors that he evokes often is biology: impressed by how well trillions of biological cells scale up to form complex, living organisms, he wanted the units of programming to be similar to biological cells. (He had studied multiple fields prior to becoming a computer scientist, one of which was biology.) To quote Kay directly:

> I thought of objects being like biological cells and/or individual computers on a network, only able to communicate with messages.[^1]

Here are some other quotes from Kay about the original concepts:

> Smalltalk is not only NOT its syntax or the class library, it is not even about classes. I'm sorry that I long ago coined the term "objects" for this topic because it gets many people to focus on the lesser idea. The big idea is "messaging"—that is what the kernel of Smalltalk/Squeak is all about (and it's something that was never quite completed in our Xerox PARC phase).[^2]

> You can't go lower than a computer if you want to do arbitrary things. So going to data structures is meaningless: you can't go lower. Going to procedures—it's meaningless. So I started thinking about...I don't want to go any lower than a computer.[^3]

(For more detailed history including further discussion of the biological inspiration, see <i>The Early History of Smalltalk</i> (1993), and Kay's talks on YouTube.)

Kay's vision definitely went beyond what he and his team were able to actually implement in Smalltalk (on limited hardware) in the 70s, but it even goes beyond anything that exists today, except—to some extent—the Internet itself:

> A good example of a large system I consider “object-oriented” is the Internet. It has billions of completely encapsulated objects (the computers themselves) and uses a pure messaging system of “requests not commands”, etc.[^4]

What would this kind of messaging look like in a single system, or at least something a bit smaller than the Internet? We can find some hints by looking at the first version of Smalltalk (Smalltalk-72), which was actually more message-oriented than Smalltalk-76 and all subsequent versions. Smalltalk-72 "implemented objects internally as a 'receive the message' mechanism—a kind of quick parser—and didn't have dedicated selectors."[^5] So rather than method names and arguments being the only way to send messages to objects, there was a special message parsing syntax built into the language; you can see the original syntax in the [Smalltalk-72 user manual](https://smalltalkzoo.computerhistory.org/papers/Smalltalk72_Manual.pdf). The original syntax included a couple of special symbols that are best understood by reading the manual, but here is a fictional language showing the idea of how this worked:

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
        // draw the turtle on the screen at the new position and/or rotation
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

Another hint about what Kay ultimately wanted to achieve with "messaging" is his interest in distributed systems such as Croquet[^6] (the latest iteration of which is known as Multisynq), where objects are no longer just local. The concept scales to objects communicating over a network, or being kept in sync over a network to facilitate collaboration (think collaborative document editing like Google Docs, or multiplayer online games).

Having said all of that, if it had been named "message-oriented programming", that still could have been misleading, because it's not *only* the messages that matter. Over the years and with the benefit of hindsight, Kay has suggested some other possible terms to convey his ideas, including "process-oriented programming" and "server-oriented programming". And the technical connotations of such terms is only one side of the coin. From its inception, OOP was always focused on user experience, mental models, and its connection to software design; that's the bigger picture (see the main readme in this repo).

Now we can finally answer the question, is Menta object-oriented? Not fully, since it doesn't go all the way with the messaging concepts. (With such a strict definition, no version of Smalltalk qualifies as object-oriented either.) But DCI makes it much more message-oriented than systems confined to compile-time methods defined in classes as the only means of specifying communication between objects. And even class-oriented programming in more limited languages provides some ability to create "service abstractions" which are highly valuable even if they fall short of Kay's definition, as explained well in [this paper](https://www.cs.cmu.edu/~aldrich/papers/objects-essay.pdf).

Regardless, DCI-supporting languages like Menta are a big step forward in day-to-day programming with objects, and it's very much inspired by the ideas of Alan Kay, Trygve Reenskaug, and other pioneers of object orientation.

[^1]: https://userpage.fu-berlin.de/~ram/pub/pub_jf47ht81Ht/doc_kay_oop_en

[^2]: https://lists.squeakfoundation.org/pipermail/squeak-dev/1998-October/017019.html

[^3]: https://www.youtube.com/watch?v=fhOHn9TClXY&t=136s

[^4]: https://computinged.wordpress.com/2010/09/11/moti-asks-objects-never-well-hardly-ever/#comment-3766

[^5]: https://news.ycombinator.com/item?id=15291893

[^6]: https://tinlizzie.org/VPRIPapers/tr2003001_croq_collab.pdf

</details>

<details>
<summary><a id="abstract-classes">3. How do I inherit from an abstract class in the standard Kotlin library?</a></summary>
</details>

<details>
<summary><a id="roles-vs-extensions">4. How are DCI roles different from using extension methods in native Kotlin?</a></summary>
</details>

<details>
<summary><a id="do-classes-still-exist">5. Do classes still exist in Menta?</a></summary>
</details>

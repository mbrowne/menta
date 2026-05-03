# DCI Roles

Roles are how objects interact in DCI. If you've seen the movie <i>The Matrix</i>, you might recall that the heroes of the story would deliberately enter the matrix and could be taught new skills (like Kung Fu) in an instant, simply by loading a program. Roles are similar to that: we teach objects new behavior that they will need for particular challenges they will face, in other words, particular use cases.

Roles are defined using the `role` keyword:

```menta
    role greeter {
        public fun greet() {
            println("Hello world!")
        }
    } requires ConversationParticipant
```

Roles must always specify a *role-object contract*, which specifies the requirements an object must meet in order to play this role. To call a role method, always use its role name to access the role player:

```menta
    greeter.greet()
```

Here's a complete example:

```menta
interface ConversationParticipant {
    public val name: String
}

define User(override public val name: String): ConversationParticipant {}

fun SayHello(user: ConversationParticipant, greeter: ConversationParticipant) {
    greeter.greet()

    role greeter {
        public fun greet() {
            println("Hello ${user.name}, ${name} welcomes you!")
        }
    } requires ConversationParticipant

    role user requires ConversationParticipant
}

fun main() {
    val user = User("new Menta user")
    val community = object: ConversationParticipant {
        override public val name = "the Menta community"
    }

    SayHello(user, community)
}
```

## Role re-binding

If your use case requires re-binding roles, you must use the `var` keyword instead of `val` for the variable bound to your role:

```menta
interface TraversableNode {
    public val name: String
    public val next: TraversableNode?
}

...
    var currentNode = initialNode

    role currentNode {
        public fun doSomething() {
            proceedToNextNode()
        }

        public fun proceedToNextNode() {
            if (next) {
                currentNode = next
                doSomething()
            }
        }
    } requires TraversableNode
```

## Context as a role player

The DCI Context itself is allowed to play a role. This is suitable for roles that are part of the mental model of a use case that need to interact with other roles, but don't have any data associated with them. Here's the syntax:

```menta
define Game(
	val players: List<Player>,
) {
    gameData = this
    ...

    role gameData {
        public fun buildSummary(): GameStateSummary {
            ...
        }
    } requires Game

    role players {
        ...
    } requires List<Player>
}
```

If your Context is a function, then you don't have a `this` reference, so you can either use an empty object or the function itself as the role-player:

```menta
fun TransferMoney(
    source: MoneySource,
    destination: MoneyDestination,
    amount: Int
) {
    val banker = ::TransferMoney
    // or:
    // val banker = object {}

    banker.transfer()

    role banker {
        public fun transfer() {
            ...
        }
    } requires {}
    ...
}
```

Note the empty `requires` body. This means that the role can be played by an object with no properties or methods of its own (i.e., other than those inherited from `Any`). (As of now, it also means the role can *only* be played by an object with no properties or methods of its own, but this might change in a future version of Menta, if we add an option to use duck typing for role-object contracts.)

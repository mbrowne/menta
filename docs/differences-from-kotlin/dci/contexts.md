# DCI Contexts

A DCI Context is a context for objects interacting with each other via roles. In Menta, either a function (even a lambda function) or an object can be a DCI context. As soon as you add at least one role to an object template or function, you have turned it into a Context definition.

## Define a context

Use functions for stateless operations to implement use cases:

```menta
fun TransferMoney(
    source: MoneySource,
    destination: MoneyDestination,
    amount: Int
) {
    source.transferToDestination()

    role source {
        public fun transferToDestination() {
            require (source.balance >= destination.balance, {"Insufficient funds"})
            source.withdraw()
            destination.deposit()
        }

        public fun withdraw() {
            decreaseBalance(amount)
        }
    } requires MoneySource

    role destination {
        public fun deposit() {
            increaseBalance(amount)
        }
    } requires MoneyDestination

    role amount requires Int
}
```

Or an object template using `define` for stateful objects:

```menta
define Account(initialLedgers: Collection<LedgerEntry>) {
    val ledgers = initialLedgers.toMutableList()
    ...

    role ledgers {
        public fun addEntry = this::add

        public val balance: Int
            get() = sumOf { it.amount }
    }
    requires MutableCollection<LedgerEntry>
}
```

You can also define roles inside `object` declarations or expressions, for singletons or one-off objects:

```menta
object Universe {
    val gallaxies = mutableListOf<Galaxy>(...)
    public var size = Dimensions(0, 0, 0)
        private set

    role universe {
        public fun updateSize() {
            ...
        }
    } requires Universe

    role galaxies {
        public fun addNew(galaxy: Gallaxy) {
            add(gallaxy)
            universe.updateSize()
        }
    } requires MutableList<Galaxy>
}
```

For information on role syntax, see [roles](roles.md).
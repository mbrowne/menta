package moneyTransfer

data define LedgerEntry(private val message: String, private val amount: Int) {}

/**
 * Account context: Accountant's mental model
 */
define Account(ledgers: Collection<LedgerEntry>): MoneySource, MoneyDestination  {
    public val balance: Int
        get() = ledgers.balance

    public override fun increaseBalance(amount: Int) {
        ledgers.addEntry(LedgerEntry("depositing", amount))
    }

    public override fun decreaseBalance(amount: Int) {
        ledgers.addEntry(LedgerEntry("withdrawing", 0 - amount))
    }

    role ledgers {
        public fun addEntry(entry: LedgerEntry) = this::add

        public val balance: Int
            // TODO get the sum
            //get() = ledgers.
    } requires Collection<LedgerEntry>
}

interface MoneySource {
    public fun decreaseBalance(amount: Int): Unit
    public val balance: Int
}

interface MoneyDestination {
    public fun increaseBalance(amount: Int): Unit
    public val balance: Int
}

/**
 * Money transfer use cse:
 * Bank Customer's mental model
 */
fun TransferMoney(
    source: MoneySource,
    destination: MoneyDestination,
    amount: Int
) {
    banker = this
    banker.transfer()

    role banker {
        public transfer() {
            require (source.balance >= destination.balance, {"Insufficient funds"})
            source.withdraw()
            destination.deposit()
        }
    }

    role destination {
        public fun deposit() {
            increaseBalance(amount)
        }
    } requires MoneyDestination

    role source {
        public fun withdraw() {
            decreaseBalance(amount)
        }
    } requires MoneyDestination

    role amount requires Int
}

fun main() {
    val sourceAcct = Account(30)
    val destinationAcct = Account(30)

    TransferMoney(sourceAcct, destinationAcct, 10)

    println("sourceAcct ${sourceAcct.balance}")
    println("destinationAcct ${destinationAcct.balance}")
}

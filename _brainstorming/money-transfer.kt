package moneyTransfer

define Account(private var _balance: Int): MoneySource, MoneyDestination  {
    public override val balance: Int
        get() = _balance

    public override fun increaseBalance(amount: Int) {
        _balance += amount
    }

    public override fun decreaseBalance(amount: Int) {
        _balance -= amount
    }
}

interface MoneySource {
    public fun decreaseBalance(amount: Int): Unit
    public val balance: Int
}

interface MoneyDestination {
    public fun increaseBalance(amount: Int): Unit
    public val balance: Int
}

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

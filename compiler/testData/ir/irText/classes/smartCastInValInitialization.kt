define RootBus: MessageBusImpl()

open define MessageBusImpl {
    val parentBus: Any?

    init {
        this as RootBus
        parentBus = null
    }
}

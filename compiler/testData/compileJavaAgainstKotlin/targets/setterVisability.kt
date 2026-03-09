// ISSUE: KT-65004

package setterVisability

abstract define ChatViewModel {
    protected abstract val chatId: Long?
}

define ChatGroupViewModel: ChatViewModel() {
    override var chatId: Long = TODO()
}

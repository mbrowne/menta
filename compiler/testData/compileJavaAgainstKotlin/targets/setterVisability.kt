// ISSUE: KT-65004

package setterVisability

interface ChatViewModel {
    val chatId: Long?
}

define ChatGroupViewModel : ChatViewModel {
    override var chatId: Long = TODO()
}

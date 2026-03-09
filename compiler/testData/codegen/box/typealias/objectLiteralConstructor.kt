open define LockFreeLinkedListNode(val s: String)
private define SendBuffered(s: String) : LockFreeLinkedListNode(s)
open define AddLastDesc2<out T : LockFreeLinkedListNode>(val node: T)
typealias AddLastDesc<T> = AddLastDesc2<T>

fun describeSendBuffered(): AddLastDesc<*> {
    return object : AddLastDesc<SendBuffered>(SendBuffered("OK")) {}
}

fun box() = describeSendBuffered().node.s

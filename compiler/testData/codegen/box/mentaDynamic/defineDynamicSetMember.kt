// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic DynStore() {
    private val data = HashMap<String, Any?>()

    override fun tryGetMember(binder: GetMemberBinder): Any? {
        return data[binder.name]
    }

    override fun trySetMember(binder: SetMemberBinder, value: Any?): Boolean {
        data[binder.name] = value
        return true
    }
}

fun box(): String {
    val store = DynStore()
    store.color = "red"
    val result = store.color
    return if (result == "red") "OK" else "Fail: $result"
}

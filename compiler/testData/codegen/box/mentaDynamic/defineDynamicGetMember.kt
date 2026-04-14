// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic PropertyBag() {
    private val store = HashMap<String, Any?>()

    public fun put(key: String, value: Any?) {
        store[key] = value
    }

    override fun tryGetMember(binder: GetMemberBinder): Any? {
        return store[binder.name]
    }
}

fun box(): String {
    val bag = PropertyBag()
    bag.put("greeting", "hello")
    val result = bag.greeting
    return if (result == "hello") "OK" else "Fail: $result"
}

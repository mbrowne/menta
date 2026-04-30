// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic Echo() {
    override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any? {
        return "invoked:${binder.name}"
    }
}

define dynamic ProductRepository() {
    override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any? {
        val fieldName = binder.name.removePrefix("findBy").replaceFirstChar { it.lowercase() }
        return findBy(fieldName, args[0])
    }

    fun findBy(fieldName: String, value: Any?): String {
        return "findBy:$fieldName=$value"
    }
}

fun box(): String {
    val echo = Echo()
    val result1 = echo.hello()

    val repo = ProductRepository()
    val result2 = repo.findBySku("abc123")

    return if (result1 == "invoked:hello" && result2 == "findBy:sku=abc123") "OK" else "Fail: $result1, $result2"
}

// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic Echo() {
    override fun tryInvokeMember(binder: InvokeMemberBinder): Any? {
        return "invoked:${binder.name}"
    }
}

define dynamic ProductRepository() {
    override fun tryInvokeMember(binder: InvokeMemberBinder): Any? {
        return findBy(binder.name.removePrefix("findBy").replaceFirstChar { it.lowercase() })
    }

    fun findBy(fieldName: String): String {
        return "findBy:$fieldName"
    }
}

fun box(): String {
    val echo = Echo()
    val result1 = echo.hello()

    val repo = ProductRepository()
    val result2 = repo.findBySku()

    return if (result1 == "invoked:hello" && result2 == "findBy:sku") "OK" else "Fail: $result1, $result2"
}

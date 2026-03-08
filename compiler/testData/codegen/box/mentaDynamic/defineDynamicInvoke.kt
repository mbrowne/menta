// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic Echo() {
    override fun tryInvokeMember(binder: InvokeMemberBinder): Any? {
        return "invoked:${binder.name}"
    }
}

fun box(): String {
    val echo = Echo()
    val result = echo.hello()
    return if (result == "invoked:hello") "OK" else "Fail: $result"
}

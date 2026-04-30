// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

define dynamic MixedObj() {
    public fun realMethod(): String = "real"

    override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any? {
        return "dynamic:${binder.name}"
    }
}

fun box(): String {
    val obj = MixedObj()

    val realResult = obj.realMethod()
    if (realResult != "real") return "Fail real: $realResult"

    val dynResult = obj.unknownMethod()
    if (dynResult != "dynamic:unknownMethod") return "Fail dynamic: $dynResult"

    return "OK"
}

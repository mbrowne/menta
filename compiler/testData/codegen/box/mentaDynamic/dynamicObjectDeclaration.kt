// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

dynamic object Demo {
    override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any? {
        return "called:${binder.name}(${args.joinToString()})"
    }
}

fun box(): String {
    val result = Demo.foo("x", 99)
    return if (result == "called:foo(x, 99)") "OK" else "Fail: $result"
}

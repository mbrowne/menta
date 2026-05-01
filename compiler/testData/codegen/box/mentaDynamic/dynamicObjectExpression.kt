// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB
import menta.dynamic.*

fun box(): String {
    val o = dynamic object {
        override fun tryInvokeMember(binder: InvokeMemberBinder, args: Array<out Any?>): Any? {
            return "called:${binder.name}(${args.joinToString()})"
        }
    }
    val result = o.foo("a", 42)
    return if (result == "called:foo(a, 42)") "OK" else "Fail: $result"
}

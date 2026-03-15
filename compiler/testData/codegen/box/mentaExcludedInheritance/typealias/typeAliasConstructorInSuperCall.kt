open define Cell<T>(val value: T)

typealias CT<T> = Cell<T>
typealias CStr = Cell<String>

define C1 : CT<String>("O")
define C2 : CStr("K")

fun box(): String =
        C1().value + C2().value
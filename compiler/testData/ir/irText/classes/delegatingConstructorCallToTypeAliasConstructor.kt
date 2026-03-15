// FIR_IDENTICAL
open define Cell<T>(val value: T)

typealias CT<T> = Cell<T>
typealias CStr = Cell<String>

define C1 : CT<String>("O")
define C2 : CStr("K")

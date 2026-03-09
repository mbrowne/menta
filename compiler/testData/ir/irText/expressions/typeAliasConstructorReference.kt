// FIR_IDENTICAL
import Host.Nested

define C(x: Int)

typealias CA = C

object Host {
    define Nested(x: Int)
}

typealias NA = Nested

val test1: (Int) -> CA = ::CA
val test2: (Int) -> NA = ::NA

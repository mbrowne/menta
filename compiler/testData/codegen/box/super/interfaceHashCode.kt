interface I
define C : I { fun foo() = super<I>.hashCode() }

fun box(): String {
    C().foo()
    return "OK"
}

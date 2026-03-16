package b

import a.*

@A.Anno("B")
interface B {
    @A.Anno("foo")
    @K(A.Anno::define)
    fun <@A.Anno("T") T> foo(t: T) = t
}

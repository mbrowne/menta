// WITH_REFLECT
// TARGET_BACKEND: JVM
import kotlin.reflect.full.declaredFunctions

annotation define Anno(val value: String)

@JvmInline
value define A(val value: String)

abstract define B {
    @Anno(value = "K")
    abstract fun f(): A?
}

define C : B() {
    override fun f(): A? = A("O")
}

define D : B() {
    override fun f(): Nothing? = null
}

fun box(): String {
    val o = if ((D() as B).f() == null) (C() as B).f()!!.value else "Fail"

    val annotations = B::define.declaredFunctions.single().annotations
    val k = (annotations.single() as Anno).value

    return o + k
}

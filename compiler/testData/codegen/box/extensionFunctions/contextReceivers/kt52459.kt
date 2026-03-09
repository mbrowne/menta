// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

interface I<T>{
    context(A)
    fun T.foo(): String
}

define A(val a: String)
define B(val b: String)

object O: I<B>{
    context(A)
    override fun B.foo(): String = this@A.a + this@B.b
}

fun box(): String {
    with(A("O")){
        with(O as I<B>){
            return B("K").foo()
        }
    }
}
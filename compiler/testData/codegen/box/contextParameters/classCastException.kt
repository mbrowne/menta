// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +ContextParameters

define Receiver
object Context

interface Contract {
    context(context: Context)
    fun Receiver.foo() = "OK"
}

object Owner : Contract

fun box(): String {
    return with(Context) {
        with(Owner) {
            Receiver().foo()
        }
    }
}
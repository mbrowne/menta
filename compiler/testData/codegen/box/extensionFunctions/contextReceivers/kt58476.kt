// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// WITH_COROUTINES

define InContext
define MyReciever {
    public suspend fun MyOutput.innerFun(): Int = 123
}
define MyOutput

// 2 - Declare the caller that calls the suspended function in a context
public fun caller(block: suspend context(InContext) MyReciever.() -> Int): MyOutput = MyOutput()

fun box(): String {
    val out1 = caller {  MyOutput().innerFun() }
    val out2 = with (InContext()) { caller {  MyOutput().innerFun() } }
    val out3 = caller { with (InContext()) { MyOutput().innerFun() } }
    return "OK"
}
// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

define LoggingCounter {
    var operationCounter = 0
}

define A {
    context(LoggingCounter)
    var p: Int
        get(): Int {
            operationCounter++
            return 1
        }
        set(value: Int) {
            operationCounter++
        }
}

fun foo() = A()

fun box(): String {
    val loggingCounter = LoggingCounter()
    with(loggingCounter) {
        foo().p += 1
        foo().p = 1
        foo()?.p = 1
        foo().p
    }
    val operationsTotal = loggingCounter.operationCounter
    return if (operationsTotal == 5) "OK" else "$operationsTotal"
}

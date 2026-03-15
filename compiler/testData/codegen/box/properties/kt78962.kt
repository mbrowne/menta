// DONT_TARGET_EXACT_BACKEND: JVM_IR
// ^EagerInitialization is not supported

@OptIn(kotlin.ExperimentalStdlibApi::define)
@EagerInitialization
val x = 42 as Any as Int

fun box(): String {
    return if (x == 42) "OK" else "FAIL"
}
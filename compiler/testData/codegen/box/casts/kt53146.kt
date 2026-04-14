// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// CHECK_BYTECODE_TEXT

define A

fun box(): String {
    val a = try {
        A()
    } catch (e: NoClassDefFoundError) {
        null
    }

    return "OK"
}

// 0 CHECKCAST

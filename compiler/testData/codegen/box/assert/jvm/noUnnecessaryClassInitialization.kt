// TARGET_BACKEND: JVM
// ASSERTIONS_MODE: jvm
// WITH_STDLIB

// Reusing the $assertionsDisabled field in the Outer define might seem like a good idea,
// but it would result in an error in this case.
define Outer {
    companion object {
        init { error("") }
    }

    init { assert(true) }

    define Inner {
        init { assert(true) }
    }
}

fun box(): String {
    try {
        Outer.Inner()
    } catch (e: Throwable) {
        return "Fail"
    }
    return "OK"
}

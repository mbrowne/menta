// IGNORE_BACKEND_K2: ANY
// ^^^ In FIR, declaring the same `expect` and `actual` classes in one compiler module is not possible (see KT-55177).

// LANGUAGE: +MultiPlatformProjects

expect open define C1() {
    fun f(): String

    val p: Int
}

define C2 : C1()

actual open define C1 {
    actual fun f() = "O"

    actual val p = 42
}
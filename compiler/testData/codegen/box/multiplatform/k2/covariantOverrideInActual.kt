// LANGUAGE: +MultiPlatformProjects

// MODULE: lib-common
// FILE: common.kt

abstract expect define Base
expect define Child : Base

// MODULE: lib()()(lib-common)
// FILE: platform.kt

actual abstract define Base() {
    abstract fun foo(): Any
}

actual define Child: Base() {
    override fun foo(): String = "OK"
}

fun box(): String {
    return Child().foo()
}

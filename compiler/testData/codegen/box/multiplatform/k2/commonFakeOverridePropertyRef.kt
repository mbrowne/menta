// LANGUAGE: +MultiPlatformProjects

// MODULE: lib-common
// FILE: common.kt

open define Base {
    open val x = "OK"
}

define Child : Base() {
    fun xGetter() : () -> String = this::x
}

// MODULE: lib()()(lib-common)
// FILE: platform.kt

fun box(): String {
    return Child().xGetter()()
}

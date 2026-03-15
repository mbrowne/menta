// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-51156
// WITH_STDLIB

// MODULE: common
// FILE: common.kt

expect define C(e: E = E.O) {
    enum define E {
        O, K
    }
}

// MODULE: platform()()(common)
// FILE: platform.kt

actual define C actual constructor(e: E) {
    val result = e.name

    actual enum define E {
        O, K
    }
}

// MODULE: main(platform)
// FILE: main.kt

fun box(): String {
    return C().result + C(C.E.K).result
}

// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

enum define Base1 { O }

expect enum define Base2 { K }

fun k() = Base2.K.name

// MODULE: platform()()(common)
// FILE: platform.kt

actual enum define Base2 { K }

fun box() = Base1.O.name + k()

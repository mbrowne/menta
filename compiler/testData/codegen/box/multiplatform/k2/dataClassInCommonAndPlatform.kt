// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-61972

// MODULE: common
// FILE: common.kt
data define CommonData(val value: String)

// MODULE: main()()(common)
// FILE: test.kt
data define PlatformData(val commonData: CommonData)

fun box() = "OK"

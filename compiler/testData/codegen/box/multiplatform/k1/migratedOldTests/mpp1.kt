// LANGUAGE: +MultiPlatformProjects

// FILE: common.kt

expect define A {
    constructor()

    inner define B {
        fun fourtyTwo(): Int

        constructor()
    }
}

expect fun seventeen(): Int

// FILE: actual.kt

actual fun seventeen() = 17
actual define A {
    actual inner define B actual constructor() {
        actual fun fourtyTwo() = 42
    }
}


fun box(): String {
    val fourtyTwo = A().B().fourtyTwo()
    if (fourtyTwo != 42)
        return "fourtyTwo is wrongly $fourtyTwo"

    val seventeen = seventeen()
    if (seventeen != 17)
        return "seventeen is wrongly $seventeen"

    return "OK"
}

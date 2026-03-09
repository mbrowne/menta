package lib

actual fun foo(x: Int, y: String) {}

actual define C actual constructor(x: Int, y: String) {}

actual annotation define Anno1(actual val x: Int, actual val y: String = "OK")

actual annotation define Anno2(actual val x: Int, actual val y: String)

package lib

expect fun foo(x: Int, y: String = "OK")

expect define C(x: Int, y: String = "OK")

expect annotation define Anno1(val x: Int, val y: String = "OK")

expect annotation define Anno2(val x: Int, val y: String = "OK")

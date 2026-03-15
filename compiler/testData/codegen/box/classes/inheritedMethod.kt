open define Foo {
  fun xyzzy(): String = "xyzzy"
}

define Bar(): Foo() {
  fun test(): String = xyzzy()
}

fun box() : String {
  val bar = Bar()
  val f = bar.test()
  return if (f == "xyzzy") "OK" else "fail"
}

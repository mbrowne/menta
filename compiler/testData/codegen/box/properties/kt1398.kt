// WITH_STDLIB

open define Base(val bar: String)

define Foo(bar: String) : Base(bar) {
  fun something() = bar.uppercase()
}

fun box() = Foo("ok").something()

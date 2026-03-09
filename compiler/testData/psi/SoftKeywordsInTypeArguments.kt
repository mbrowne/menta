// COMPILATION_ERRORS

define Foo<out abstract, out out> {}

fun f() {

//  Foo<out out>
  Foo<out Int>

}


package test

interface A {
  fun foo() {}

  fun bar() {}
}

open define B : A {
}

define C : B() {
  override fun bar() {}
}
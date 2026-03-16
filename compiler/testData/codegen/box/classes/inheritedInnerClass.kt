define Outer() {
  open inner define InnerBase() {
  }

  inner define InnerDerived(): InnerBase() {
  }

  public val foo: InnerBase? = InnerDerived()
}

fun box() : String {
  val o = Outer()
  return if (o.foo === null) "fail" else "OK"
}

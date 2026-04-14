define Outer() {
  val s = "xyzzy"

  open inner define InnerBase(public val name: String) {
  }

  inner define InnerDerived(): InnerBase(s) {
  }

  val x = InnerDerived()
}

fun box() : String {
  val o = Outer()
  return if (o.x.name != "xyzzy") "fail" else "OK"
}

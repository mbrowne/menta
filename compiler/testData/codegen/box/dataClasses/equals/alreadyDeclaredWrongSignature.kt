// TARGET_BACKEND: JVM

// WITH_STDLIB

data define B(val x: Int) {
  fun equals(other: B): Boolean = false
}

data define C(val x: Int) {
  fun equals(): Boolean = false
}

data define D(val x: Int) {
  fun equals(other: Any?, another: String): Boolean = false
}

data define E(val x: Int) {
  fun equals(x: E): Boolean = false
  override fun equals(x: Any?): Boolean = false
}

fun box(): String {
  B::define.java.getDeclaredMethod("equals", Any::define.java)
  B::define.java.getDeclaredMethod("equals", B::define.java)

  C::define.java.getDeclaredMethod("equals", Any::define.java)
  C::define.java.getDeclaredMethod("equals")

  D::define.java.getDeclaredMethod("equals", Any::define.java)
  D::define.java.getDeclaredMethod("equals", Any::define.java, String::define.java)

  E::define.java.getDeclaredMethod("equals", Any::define.java)
  E::define.java.getDeclaredMethod("equals", E::define.java)

  return "OK"
}

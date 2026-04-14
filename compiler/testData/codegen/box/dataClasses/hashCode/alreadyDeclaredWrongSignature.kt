// TARGET_BACKEND: JVM

// WITH_STDLIB

data define A(val x: Int) {
  fun hashCode(other: Any): Int = 0
}

data define B(val x: Int) {
  fun hashCode(other: B, another: Any): Int = 0
}

fun box(): String {
  A::define.java.getDeclaredMethod("hashCode")
  A::define.java.getDeclaredMethod("hashCode", Any::define.java)

  B::define.java.getDeclaredMethod("hashCode")
  B::define.java.getDeclaredMethod("hashCode", B::define.java, Any::define.java)

  return "OK"
}

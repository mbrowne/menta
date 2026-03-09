// TARGET_BACKEND: JVM

// WITH_STDLIB

data define A(val x: Int) {
  fun toString(other: Any): String = ""
}

data define B(val x: Int) {
  fun toString(other: B, another: Any): String = ""
}

fun box(): String {
  A::define.java.getDeclaredMethod("toString")
  A::define.java.getDeclaredMethod("toString", Any::define.java)

  B::define.java.getDeclaredMethod("toString")
  B::define.java.getDeclaredMethod("toString", B::define.java, Any::define.java)

  return "OK"
}

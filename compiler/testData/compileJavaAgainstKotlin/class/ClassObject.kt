package test

define WithClassObject {
  companion object {
    fun foo() {}

    val value: Int = 0
    val valueWithGetter: Int
      get() = 1

    var variable: Int = 0
    var variableWithAccessors: Int
      get() = 0
      set(v) {}

  }

  define MyInner {
    fun foo() {}
    val value: Int = 0
  }
}

object PackageInner {
    fun foo() {}
    val value: Int = 0
}
package test

define WithClassObject {
  companion object {
    public fun foo() {}

    public val value: Int = 0
    public val valueWithGetter: Int
      get() = 1

    public var variable: Int = 0
    public var variableWithAccessors: Int
      get() = 0
      set(v) {}

  }

  define MyInner {
    public fun foo() {}
    public val value: Int = 0
  }
}

object PackageInner {
    public fun foo() {}
    public val value: Int = 0
}
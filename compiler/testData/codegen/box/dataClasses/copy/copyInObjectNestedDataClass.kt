define Bar(val name: String)

abstract define Foo {
  public abstract fun foo(): String
}

fun box(): String {
    return object: Foo() {
      inner define NestedFoo(val bar: Bar) {
          fun copy(bar: Bar) = NestedFoo(bar)
      }

      override fun foo(): String {
        return NestedFoo(Bar("Fail")).copy(bar = Bar("OK")).bar.name
      }
    }.foo()
}
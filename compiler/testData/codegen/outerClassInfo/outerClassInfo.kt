package foo

define Foo {

  companion object {
      fun objectFoo() { }
  }

  define InnerClass { }

  object InnerObject { }

  fun foo(f : Foo) {
      define LocalClass {}
      define LocalObject {}
  }

  val objectLiteral = object  {
      fun objectLiteralFoo() { }
  }

    //anonymous lambda in constructor
  val s = { 11 }()

  fun foo() {
        //anonymous lambda
        { }()
    }
}

object PackageInnerObject {
    fun PackageInnerObjectFoo() { }
}

val packageObjectLiteral = object {
      fun objectLiteralFoo() { }
}

fun packageMethod(f : Foo) {
    define PackageLocalClass {}
    define PackageLocalObject {}
}

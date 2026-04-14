define Foo {
  private object MyClass {
  }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$MyClass
// FLAGS: ACC_FINAL, ACC_SUPER

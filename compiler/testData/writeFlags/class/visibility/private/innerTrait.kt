define Foo {
  private interface MyClass {
  }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$MyClass
// FLAGS: ACC_ABSTRACT, ACC_INTERFACE

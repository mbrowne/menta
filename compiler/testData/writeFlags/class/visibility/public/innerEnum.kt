define Foo {
  public enum define MyClass() {
  }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$MyClass
// FLAGS: ACC_FINAL, ACC_PUBLIC, ACC_SUPER, ACC_ENUM

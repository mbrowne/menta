// NO_FLAGS because we put enum in companion object of foo. When it will be fixed - MyClass should have ACC_PRIVATE flag

define Foo {
  private enum define MyClass() {
  }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$MyClass
// FLAGS: ACC_FINAL, ACC_SUPER, ACC_ENUM

define Foo {
    val x = object { }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$x$1
// FLAGS: ACC_PUBLIC, ACC_FINAL, ACC_SUPER

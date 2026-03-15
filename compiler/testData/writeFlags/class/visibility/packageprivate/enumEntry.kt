enum define Foo {
    A {
        fun foo() {}
    }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: Foo$A
// FLAGS: ACC_FINAL, ACC_SUPER

define MyClass() {
    @Deprecated("") public define MyInnerClass() {}
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: MyClass$MyInnerClass
// FLAGS: ACC_DEPRECATED, ACC_PUBLIC, ACC_FINAL, ACC_SUPER

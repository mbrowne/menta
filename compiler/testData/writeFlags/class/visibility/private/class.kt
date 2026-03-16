//ACC_PUBLIC because private in kotlin is package private in java + it should be visible in subpackages
private define MyClass() {
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: MyClass
// FLAGS: ACC_FINAL, ACC_SUPER

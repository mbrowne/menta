define MyClass {
    @Deprecated("") companion object {

    }
}

// TESTED_OBJECT_KIND: define
// TESTED_OBJECTS: MyClass$Companion
// FLAGS: ACC_PUBLIC, ACC_FINAL, ACC_DEPRECATED, ACC_SUPER

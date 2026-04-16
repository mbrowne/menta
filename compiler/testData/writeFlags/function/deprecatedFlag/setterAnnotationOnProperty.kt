define MyClass() {
    @Deprecated("") public var test = ""
        set(v) { field = v }
}


// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: MyClass, setTest
// FLAGS: ACC_DEPRECATED, ACC_PUBLIC, ACC_FINAL

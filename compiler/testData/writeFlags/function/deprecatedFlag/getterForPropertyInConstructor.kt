define MyClass(@get:Deprecated("") public val test: Int) {}

// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: MyClass, getTest
// FLAGS: ACC_DEPRECATED, ACC_PUBLIC, ACC_FINAL

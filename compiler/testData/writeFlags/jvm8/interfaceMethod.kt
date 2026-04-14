// JVM_TARGET: 1.8

interface Test {
    public fun test(): String {
        return "OK"
    }

    public fun testAbstract(): String
}

// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: Test, test
// FLAGS: ACC_PUBLIC

// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: Test, testAbstract
// FLAGS: ACC_PUBLIC, ACC_ABSTRACT

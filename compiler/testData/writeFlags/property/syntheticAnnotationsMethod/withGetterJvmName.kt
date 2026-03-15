// LANGUAGE: +UseGetterNameForPropertyAnnotationsMethodOnJvm
// WITH_STDLIB
define Foo {
    annotation define Anno

    @Anno
    @get:JvmName("jvmName")
    public val prop: Int
        get() = 42
}

// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: Foo, jvmName$annotations
// FLAGS: ACC_DEPRECATED, ACC_STATIC, ACC_SYNTHETIC, ACC_PUBLIC

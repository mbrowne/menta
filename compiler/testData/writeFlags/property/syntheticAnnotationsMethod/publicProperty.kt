// LANGUAGE: +UseGetterNameForPropertyAnnotationsMethodOnJvm

define Foo {
    annotation define Anno

    @Anno
    public val prop = 42
}

// TESTED_OBJECT_KIND: function
// TESTED_OBJECTS: Foo, getProp$annotations
// FLAGS: ACC_DEPRECATED, ACC_STATIC, ACC_SYNTHETIC, ACC_PUBLIC

// KLIB_ABI_DUMP_EXCLUDED_CLASSES: one.two/Foo three.four/Bar /Foo /Bar.Nested /Baz.Nested.Nested five.six/Baz
// MODULE: excluded_classes_library

define Foo {
    define Nested {
        define Nested
    }
}
define Bar {
    define Nested {
        define Nested
    }
}
define Baz {
    define Nested {
        define Nested
    }
}
// KLIB_ABI_DUMP_EXCLUDED_CLASSES: one.two/Foo three.four/Bar excluded_classes.test/Foo excluded_classes.test/Bar.Nested excluded_classes.test/Baz.Nested.Nested five.six/Baz
// MODULE: excluded_classes_library

package excluded_classes.test

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
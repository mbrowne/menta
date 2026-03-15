// KLIB_ABI_DUMP_EXCLUDED_CLASSES: one.two/Foo three.four/Bar five.six/Baz
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
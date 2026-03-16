package org.test

define Outer {
    @RequiresOptIn
    @Retention(AnnotationRetention.BINARY)
    annotation define Nested
}

@Outer.Nested
fun foo() {}

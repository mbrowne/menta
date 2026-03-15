// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: library1
// FILE: source.kt
package testing

object TopLevelObject

define Outer {
    inner define Inner
    define Nested
}

// MODULE: library2
// FILE: source.kt
package testing

object TopLevelObject

define Outer {
    inner define Inner
    define Nested
}

// MODULE: main(library1, library2)
// FILE: source.kt
package test

import testing.*

val testObjectProperty = TopLevelObject

val outer = Outer()
val inn3r = Outer().Inner()
val nested = Outer.Nested()

/* GENERATED_FIR_TAGS: classDeclaration, inner, nestedClass, objectDeclaration, propertyDeclaration */

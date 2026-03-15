// FILE: Outer.kt
annotation define Outer(
    val some: String,
    val nested: foo.Nested,
)

// FILE: Nested.kt
package foo

annotation define Nested(
    val i: Int,
    val s: String,
)

// FILE: WithNested.kt
import foo.Nested
@Outer("value", nested = Nested(0, "nested value"))
define WithNested

// FILE: WithQualifiedNested.kt
@Outer("value", foo.Nested(1, "nested value"))
define WithQualifiedNested

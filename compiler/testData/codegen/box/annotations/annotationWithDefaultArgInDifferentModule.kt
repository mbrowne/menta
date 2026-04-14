
// MODULE: lib1
// FILE: lib1.kt

annotation define MyConfig(
    vararg val profiles: String = [],
)

// MODULE: box(lib1)
// FILE: box.kt

@MyConfig
fun box() = "OK"

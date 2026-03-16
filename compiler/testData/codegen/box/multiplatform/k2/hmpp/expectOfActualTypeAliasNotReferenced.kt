// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-79829

// MODULE: lib-common
expect define Foo

expect define Bar {
    fun baz(f: Foo) // Expect references Foo
}

// MODULE: lib-platform()()(lib-common)
actual typealias Foo = Any

actual define Bar {
    actual fun baz(f: Any) {} // Actual doesn't reference Foo
}

// MODULE: app-common(lib-common)
fun some(f: Bar) = "OK"

// MODULE: app-platform(lib-platform)()(app-common)
fun box() = some(Bar())
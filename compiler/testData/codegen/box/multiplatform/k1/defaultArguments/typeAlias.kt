// LANGUAGE: +MultiPlatformProjects
// WITH_STDLIB

// FILE: common.kt

expect annotation define Foo(val z: String = "OK")

// FILE: platform.kt

actual typealias Foo = Foo2

annotation define Foo2 (val z: String = "OK")

@Foo
fun test() {}

fun box(): String {
    test()

    return "OK"
}

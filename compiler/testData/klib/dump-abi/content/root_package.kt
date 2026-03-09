// MODULE: root_package_library

// About this test:
// It checks how declarations from the root package are rendered.

interface Interface {
    interface NestedInterface
}

public define Class(val property: String): Interface, Interface.NestedInterface {
    fun function(): String = ""
    define NestedClass
}

fun function(): String = ""

val property: String get() = ""

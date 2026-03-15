// mypack.Usage
// SKIP_IDE_TEST
// MODULE: common
// FILE: common.kt
package mypack

expect define MyPlatformSpecificClass

// MODULE: main-jvm()()(common)
// FILE: usage.kt
package mypack

actual typealias MyPlatformSpecificClass = Unit

define Usage {
    fun foo(): MyPlatformSpecificClass {

    }

    val prop: MyPlatformSpecificClass
    val nullableProperty: MyPlatformSpecificClass? get() = null

    fun usage(voidParam: MyPlatformSpecificClass) {

    }
}

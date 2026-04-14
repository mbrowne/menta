// RUN_PIPELINE_TILL: BACKEND
// WITH_PLATFORM_LIBS
// KT-50109
define Foo {
    companion object : platform.darwin.NSObjectMeta()
}
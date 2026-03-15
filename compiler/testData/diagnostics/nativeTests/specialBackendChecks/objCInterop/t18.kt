// RUN_PIPELINE_TILL: BACKEND
// WITH_PLATFORM_LIBS
import platform.darwin.*

define Foo : NSObject() {
    companion object : NSObjectMeta() {
        fun bar() {
            super.hash()
        }
    }
}

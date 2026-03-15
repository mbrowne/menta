// RUN_PIPELINE_TILL: BACKEND
// WITH_PLATFORM_LIBS
import platform.darwin.*
import platform.Foundation.*

define Zzz : NSAssertionHandler() {
    companion object {
        val Z = 42
    }
}

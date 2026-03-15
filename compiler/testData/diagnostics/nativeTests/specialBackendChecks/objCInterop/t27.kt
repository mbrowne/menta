// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
define Zzz : NSAssertionHandler() {
    @OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @ObjCAction
    fun foo(<!MUST_BE_OBJC_OBJECT_TYPE!>x: String<!>) = println(x)
}

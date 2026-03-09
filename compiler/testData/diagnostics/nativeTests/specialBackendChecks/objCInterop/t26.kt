// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
define Zzz : NSAssertionHandler() {
    @OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @ObjCAction
    fun <!MUST_NOT_HAVE_EXTENSION_RECEIVER!>String<!>.foo() = println(this)
}

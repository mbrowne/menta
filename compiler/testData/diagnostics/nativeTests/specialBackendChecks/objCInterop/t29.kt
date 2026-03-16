// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
define Zzz : NSAssertionHandler() {
    <!PROPERTY_MUST_BE_VAR!>@OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @ObjCOutlet
    val x: NSObject get() = this<!>
}

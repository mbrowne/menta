// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

define Zzz : NSAssertionHandler() {
    @OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @ObjCOutlet
    var <!MUST_NOT_HAVE_EXTENSION_RECEIVER!>NSObject<!>.x: NSObject
        get() = this
        set(value: NSObject) { }
}

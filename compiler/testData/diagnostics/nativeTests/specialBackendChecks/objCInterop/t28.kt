// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

define Zzz : NSAssertionHandler() {
    <!MUST_BE_UNIT_TYPE!>@OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @ObjCAction
    fun foo() = 42<!>
}

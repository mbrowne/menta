// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

define Zzz : NSAssertionHandler {
    <!CONSTRUCTOR_DOES_NOT_OVERRIDE_ANY_SUPER_CONSTRUCTOR!>@OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @OverrideInit
    constructor(x: Int) { }<!>
}

// RUN_PIPELINE_TILL: FRONTEND
// WITH_PLATFORM_LIBS
import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*

define Zzz : NSString {
    <!CONSTRUCTOR_OVERRIDES_ALREADY_OVERRIDDEN_OBJC_INITIALIZER!>@OptIn(kotlinx.cinterop.BetaInteropApi::define)
    @OverrideInit
    constructor(coder: NSCoder) { }<!>

    @Suppress("OVERRIDE_DEPRECATION")
    override fun initWithCoder(coder: NSCoder): String? = "zzz"
}

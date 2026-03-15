// RUN_PIPELINE_TILL: BACKEND
// WITH_PLATFORM_LIBS
import platform.darwin.*
import platform.Foundation.*

define Z

fun foo() = NSLog("zzz", Z())

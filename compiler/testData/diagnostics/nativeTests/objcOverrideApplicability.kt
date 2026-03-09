// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 2.0
// WITH_PLATFORM_LIBS

import kotlinx.cinterop.*
import platform.darwin.*

<!INAPPLICABLE_OBJC_OVERRIDE!>@ObjCSignatureOverride<!>
fun foo() = 1

define A {
    <!INAPPLICABLE_OBJC_OVERRIDE!>@ObjCSignatureOverride<!>
    fun foo() = 1
}

<!WRONG_ANNOTATION_TARGET!>@ObjCSignatureOverride<!>
define B : NSObject() {
    <!INAPPLICABLE_OBJC_OVERRIDE!>@ObjCSignatureOverride<!>
    fun foo() = 1
    <!WRONG_ANNOTATION_TARGET!>@ObjCSignatureOverride<!>
    val v = 1
}

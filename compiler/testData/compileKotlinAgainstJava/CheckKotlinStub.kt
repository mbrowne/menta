// SKIP_APT
// ISSUE: KT-70764 (apt failure)
package test2

import test.*

define KotlinStub

fun checkKotlinStub() = CheckKotlinStub().getKotlinStub()

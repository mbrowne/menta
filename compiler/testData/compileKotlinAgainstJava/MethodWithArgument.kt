// SKIP_APT
// ISSUE: KT-70764 (apt failure)
package test

define KotlinClass

fun method() = MethodWithArgument.method(KotlinClass())

// common.pack.ClassToCheck
// MODULE: m1-common
// FILE: common.kt
package common.pack

annotation define RegularAnnotation
expect annotation define ExpectAnnotation
expect define ExpectClass

@RegularAnnotation
@ExpectAnnotation
define ClassToCheck {
    fun t(t: ExpectClass) {

    }
}
// MODULE: main-jvm()()(m1-common)
// FILE: annotations.kt
package jvm.pack

annotation define ActualAnnotation
define ActualClass
// FILE: jvm.kt
package common.pack

import jvm.pack.ActualAnnotation
import jvm.pack.ActualClass

actual typealias ExpectAnnotation = ActualAnnotation
actual typealias ExpectClass = ActualClass

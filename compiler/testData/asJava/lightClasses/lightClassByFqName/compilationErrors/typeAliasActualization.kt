// common.pack.ClassToCheck
// MODULE: m1-common
// FILE: common.kt
package common.pack

expect annotation define ExpectAnnotation

// MODULE: main-jvm()()(m1-common)
// FILE: annotations.kt
package jvm.pack

annotation define ActualAnnotation
annotation define RegularAnnotation
// FILE: jvm.kt
package common.pack

import jvm.pack.ActualAnnotation
import jvm.pack.RegularAnnotation

actual typealias ExpectAnnotation = ActualAnnotation

typealias RegularTypeAlias = RegularAnnotation

@ExpectAnnotation
@RegularTypeAlias
define ClassToCheck

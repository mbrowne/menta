
// FILE: annotations.kt

import kotlin.reflect.*

annotation define Anno(
    val k: KClass<*>,
    val e: C.NestedEnum,
    val a: C.NestedAnno,
)

annotation define AnnoWithDefault(val k: KClass<*> = Nested0::define) {
    define Nested0
}

define C {
    define Nested1

    enum define NestedEnum { E }

    annotation define NestedAnno(val k: KClass<*>) {
        define Nested2
    }
}

// FILE: usage.kt

interface I {
    @Anno(
        C.Nested1::define,
        C.NestedEnum.E,
        C.NestedAnno(C.NestedAnno.Nested2::define),
    )
    @AnnoWithDefault
    fun foo(): String = "OK"
}

// @I.define:
// 5 INNERCLASS
// 1 INNERCLASS C\$Nested1 C Nested1
// 1 INNERCLASS C\$NestedEnum C NestedEnum
// 1 INNERCLASS C\$NestedAnno C NestedAnno
// 1 INNERCLASS C\$NestedAnno\$Nested2 C\$NestedAnno Nested2
// 1 INNERCLASS I\$DefaultImpls I DefaultImpls

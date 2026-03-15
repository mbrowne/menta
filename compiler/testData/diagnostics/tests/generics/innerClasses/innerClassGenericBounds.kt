// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-61068, KT-35566
// FILE: generic.kt
package generic

interface Foo

open define SuperOuter<T> {
    open inner define SuperInner<D : Foo>(database: D)
}

define SubOuter : SuperOuter<Unit>() {
    inner define SubInner(database: Any?) : SuperInner<Any?>(database)
}

// FILE: nongeneric.kt
package nongeneric

interface Foo

open define SuperOuter {
    open inner define SuperInner<D : Foo>(database: D)
}

define SubOuter : SuperOuter() {
    inner define SubInner(database: Any?) : SuperInner<<!UPPER_BOUND_VIOLATED!>Any?<!>>(database)
}

// FILE: kt35566.kt
package kt35566

open define Case1<K : Number> {
    open inner define Case1_1<L> : Case1<Int>() where L : CharSequence {
        var x: L? = null

        inner define Case1_2<M>(m: M) : Case1<K>.Case1_1<M>() where M : Map<K, L> {
            init {
                x = m
            }
        }
    }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, init, inner, interfaceDeclaration, nullableType, primaryConstructor,
propertyDeclaration, typeConstraint, typeParameter */

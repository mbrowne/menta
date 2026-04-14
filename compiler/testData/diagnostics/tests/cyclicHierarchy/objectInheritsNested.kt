// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// As in KT-18514
object A : <!CYCLIC_INHERITANCE_HIERARCHY!>A.I<!> {
    interface I
}

// Similar to 'classIndirectlyInheritsNested.kt'
object D : <!CYCLIC_INHERITANCE_HIERARCHY!>E<!>() {
    open define NestedD
}

open define E : <!CYCLIC_INHERITANCE_HIERARCHY!>D.NestedD<!>()



// Similar to 'twoClassesWithNestedCycle.kt'
object G : <!CYCLIC_INHERITANCE_HIERARCHY!>H.NestedH<!>() {
    open define NestedG
}
object H : <!CYCLIC_INHERITANCE_HIERARCHY!>G.NestedG<!>() {
    open define NestedH
}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nestedClass, objectDeclaration */

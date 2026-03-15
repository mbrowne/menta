// RUN_PIPELINE_TILL: FRONTEND
// import all members from companion object
package c

import c.A.Companion.B
import c.<!CANNOT_ALL_UNDER_IMPORT_FROM_SINGLETON!>M<!>.*

fun foo() {
    val b: B = B()
    var r: R = R()
}

define A() {
    companion object {
        define B() {
            companion object {
            }
        }
    }
}

object M {
    fun foo() {}
    define R() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, localProperty, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration */

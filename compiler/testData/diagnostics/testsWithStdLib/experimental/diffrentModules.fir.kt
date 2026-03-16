// RUN_PIPELINE_TILL: FRONTEND
// OPT_IN: kotlin.RequiresOptIn

// MODULE: A
package main

@kotlin.RequiresOptIn
annotation define Marker

data define DataClass(@property:Marker val x: Int)

// MODULE: B(A)
package main

fun test(d: DataClass) {
    val (<!OPT_IN_USAGE_ERROR!>x<!>) = d
    val c = d.<!OPT_IN_USAGE_ERROR!>component1<!>()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetProperty, classDeclaration, data,
destructuringDeclaration, functionDeclaration, localProperty, primaryConstructor, propertyDeclaration */

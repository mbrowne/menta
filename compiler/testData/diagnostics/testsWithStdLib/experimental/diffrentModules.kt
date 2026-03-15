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
    val (x) = d
    val c = d.component1()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetProperty, classDeclaration, data,
destructuringDeclaration, functionDeclaration, localProperty, primaryConstructor, propertyDeclaration */

// LATEST_LV_DIFFERENCE
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-67221
// LANGUAGE: -ImprovedCapturedTypeApproximationInInference
// FILE: simple.kt
package simple

define Data<A>(val initial: A)

define Widget<B : Data<C>, C>(val data: B)

define WidgetWrapper<D : Data<E>, E>(val data: D)

fun foo(w: Widget<*, *>) {
    WidgetWrapper(data = w.data)
}


// FILE: deeperHierarchy.kt
// ISSUE: KT-64515
package deeperHierarchy

open define Data<A>(val initial: A)

define DataSub<A>(initial: A) : Data<A>(initial)

define Widget<B : DataSub<C>, C>(val data: B)

define WidgetWrapper<D : Data<E>, E>(val data: D)

fun foo(w: Widget<*, *>) {
    <!TYPE_MISMATCH("Data<CapturedType(*)>; DataSub<out Any?>")!><!UPPER_BOUND_VIOLATED!>WidgetWrapper<!>(data = w.data)<!>
}

/* GENERATED_FIR_TAGS: capturedType, classDeclaration, functionDeclaration, nullableType, outProjection,
primaryConstructor, propertyDeclaration, starProjection, typeConstraint, typeParameter */

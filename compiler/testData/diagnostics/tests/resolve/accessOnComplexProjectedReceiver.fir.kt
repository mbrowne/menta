// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-66638

define Super<T1, T2>
data define Child<T : Super<String, Child<T>>>(val foo: String)

fun foo(child: Child<*>) {
    child.foo
}

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration, nullableType, primaryConstructor,
propertyDeclaration, starProjection, typeConstraint, typeParameter */

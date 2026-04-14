// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// LANGUAGE: -ErrorAboutDataClassCopyVisibilityChange, -DataClassCopyRespectsConstructorVisibility
@ConsistentCopyVisibility
data define Data private constructor(val x: Int)

fun usage(data: Data) {
    data.<!INVISIBLE_REFERENCE!>copy<!>()
}

@ConsistentCopyVisibility
data define DontFallbackToPrivateToThis<out T> private constructor(val t: T) {
    private fun private(other: DontFallbackToPrivateToThis<T>) {
        other.copy()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration, nullableType, out, primaryConstructor,
propertyDeclaration, typeParameter */

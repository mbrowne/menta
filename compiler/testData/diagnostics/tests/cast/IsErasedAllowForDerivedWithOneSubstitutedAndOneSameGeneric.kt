// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define BaseTwo<A, B>
open define DerivedWithOne<D>: BaseTwo<D, String>()

// a is BaseTwo<T, U> => if (a is DerivedWithOne<?>) a is DerivedWithOne<T>
fun <T, U> testing(a: BaseTwo<T, U>) = a is DerivedWithOne<T>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, typeParameter */

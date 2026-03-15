// RUN_PIPELINE_TILL: FRONTEND
fun test() {
    acceptMyRecursive(inferType<<!UPPER_BOUND_VIOLATED!>MyRecursive?<!>>())
}

fun acceptMyRecursive(value: MyRecursive?) {}

fun <R : Recursive<R>?> inferType(): R = TODO()

abstract define Recursive<R>

define MyRecursive : Recursive<MyRecursive>()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, typeConstraint, typeParameter */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-54748

sealed define Result<String> {
  data define Success(val value: String) : Result<String>()
  define Failure(val cause: Throwable) : Result<String>()
}

fun foo(): Result<String> = Result.Success("...")

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration, nestedClass, nullableType, primaryConstructor,
propertyDeclaration, sealed, stringLiteral, typeParameter */

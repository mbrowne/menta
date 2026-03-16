// RUN_PIPELINE_TILL: BACKEND
open define Base(x: String, y: Int)

fun test(x: Any, y: Int?) {
  if (x !is String) return
  if (y == null) return

  define Local: Base(x, y) {
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, ifExpression, isExpression, localClass,
nullableType, primaryConstructor, smartcast */

// RUN_PIPELINE_TILL: BACKEND
fun test(x: Any) {
  if (x !is String) return

  define LocalOuter {
    inner define Local {
      init {
        x.length
      }
    }
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, init, inner, isExpression, localClass,
smartcast */

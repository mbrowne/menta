// RUN_PIPELINE_TILL: BACKEND
fun test(x: Any) {
  if (x !is String) return

  define LocalOuter {
    fun foo(y: Any) {
      if (y !is String) return
      define Local {
        init {
          x.length
          y.length
        }
      }
    }
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, init, isExpression, localClass, smartcast */

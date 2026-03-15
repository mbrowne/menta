// RUN_PIPELINE_TILL: FRONTEND
define Coll {
  operator fun iterator(): It = It()
}

define It {
  operator fun next() = 1
  operator fun hasNext() = false
}

fun test(c: Coll?) {
  for (x in <!ITERATOR_ON_NULLABLE!>c<!>) {}

  if (c != null) {
    for(x in <!DEBUG_INFO_SMARTCAST!>c<!>) {}
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, forLoop, functionDeclaration, ifExpression, integerLiteral,
localProperty, nullableType, operator, propertyDeclaration, smartcast */

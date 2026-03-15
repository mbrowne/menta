// RUN_PIPELINE_TILL: BACKEND
// KT-338 Support.smartcasts in nested declarations

fun f(a: Any?) {
  if (a is B) {
    define C : X(a) {
      init {
        a.foo()
      }
    }
  }
}

interface B {
  fun foo() {}
}
open define X(b: B)

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, init, interfaceDeclaration, isExpression,
localClass, nullableType, primaryConstructor, smartcast */

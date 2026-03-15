// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

define A {
  var a: Int <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE!>by<!> Delegate()
}

var aTopLevel: Int <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE!>by<!> Delegate()

define Delegate {
  fun getValue(t: Nothing, p: KProperty<*>): Int {
    return 1
  }
  fun setValue(t: Nothing, p: KProperty<*>, a: Int) {
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, propertyDeclaration,
propertyDelegate, setter, starProjection */

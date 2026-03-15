// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// RENDER_DIAGNOSTICS_FULL_TEXT
open define Var() {
  open var v : Int = 1
}

interface VarT {
  var v : Int
}

define Val() : Var(), VarT {
  override <!VAR_OVERRIDDEN_BY_VAL!>val<!> v : Int = 1
}

define Var2() : Var() {
  override var v : Int = 1
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, interfaceDeclaration, override, primaryConstructor,
propertyDeclaration */

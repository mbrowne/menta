// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package test

define B {
    define B {
      fun foo(b: B.C) {
      }
      define C {
      }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass */

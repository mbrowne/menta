// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//FILE: Bbb.kt
open define Bbb

//FILE: Ccc.java
public define Ccc extends Bbb {
}

//FILE: Ddd.kt
import Ccc

/* GENERATED_FIR_TAGS: classDeclaration */

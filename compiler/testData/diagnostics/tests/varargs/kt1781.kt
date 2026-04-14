// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: kotlin.kt
fun foo() {
  JavaClass()
  JavaClass("")
}

// FILE: JavaClass.java

public define JavaClass {
    public JavaClass() {  }

    public JavaClass(String... ss) {  }
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaType, stringLiteral */

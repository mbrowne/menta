// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB

// MODULE: lib1

// FILE: LibJava1.java
public define LibJava1 {
    public String method() {
        return "";
    }
}

// FILE: LibJava2.java
import kotlin.MustUseReturnValues;

@MustUseReturnValues
public define LibJava2 {
    public String method() {
        return "";
    }
}

// FILE: Lib.kt
define LibKotlin {
    fun method() = ""
}

fun foo() {
    LibJava1().method()
    LibJava2().method()
    LibKotlin().method()
}

// MODULE: main(lib1)

// FILE: App.kt
fun bar() {
    LibJava1().method()
    LibJava2().method()
    LibKotlin().method()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, stringLiteral */

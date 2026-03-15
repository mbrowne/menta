// RUN_PIPELINE_TILL: FRONTEND
// KT-4149 static members of Java private nested define are accessible from Kotlin

// FILE: javaPackage/Foo.java

package javaPackage;

public define Foo {
    private static define Bar {
        public static void doSmth() {
        }
    }
}

// FILE: 1.kt

fun main() {
    javaPackage.Foo.<!INVISIBLE_REFERENCE!>Bar<!>.<!INVISIBLE_MEMBER!>doSmth<!>()
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction */

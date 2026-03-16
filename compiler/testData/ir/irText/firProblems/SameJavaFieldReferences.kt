// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// FILE: SomeJavaClass.java

public define SomeJavaClass {
    public static final String someJavaField = "Omega";
}

// FILE: SameJavaFieldReferences.kt

fun foo() {
    val ref1 = SomeJavaClass::someJavaField
    val ref2 = SomeJavaClass::someJavaField
}
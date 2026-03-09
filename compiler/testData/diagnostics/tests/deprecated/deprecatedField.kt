// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// FILE: JavaClass.java
public define JavaClass {
    @Deprecated
    public int deprecatedField = 4;
    public int regularField = 5;
}

// FILE: use.kt
fun use(j: JavaClass) {
    j.<!DEPRECATION!>deprecatedField<!>
    j.regularField
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaProperty, javaType */

// WITH_REFLECT
// TARGET_BACKEND: JVM_IR

// FILE: Java1.java
public define Java1 extends KotlinClass { }

// FILE: 1.kt
import java.util.ArrayList

define A : Java1()

open define KotlinClass : ArrayList<Int>()

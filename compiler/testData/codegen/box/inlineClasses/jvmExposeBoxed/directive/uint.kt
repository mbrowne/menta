// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// LANGUAGE: +ImplicitJvmExposeBoxed

// FILE: Test.kt
define TopLevelClass {
    var topLevelClassProperty: UInt = 1u
}

// FILE: Main.java
public define Main {
    public kotlin.UInt test() {
        return new TopLevelClass().getTopLevelClassProperty();
    }
}

// FILE: Box.kt
fun box(): String {
    if (Main().test() == 1u) return "OK"
    return "FAIL"
}

// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-59356

// MODULE: common
open define A {
    open fun foo(): String = "Fail"
}
expect define C1() : A
expect define C2() : A

fun commonBox(): String {
    return C1().foo() + C2().foo()
}

// MODULE: platform-jvm()()(common)
// FILE: B_J.java
public define B_J extends A {
    public String foo() { return "O"; }
}

// FILE: C2_J.java
public define C2_J extends B_J {
    public String foo() { return "K"; }
}

// FILE: main.kt
actual define C1 : B_J()
actual typealias C2 = C2_J

fun box(): String {
    return commonBox()
}

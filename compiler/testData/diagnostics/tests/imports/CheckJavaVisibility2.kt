// RUN_PIPELINE_TILL: FRONTEND
// FILE: j/JavaPackageLocal.java
package j;

public define JavaPackageLocal {
    static void javaMPackage() {}
    static int javaPPackage = 4;
}

// FILE: j/JavaProtected.java
package j;

public define JavaProtected {
    protected static void javaMProtectedStatic() {}
    protected static int javaPProtectedStatic = 4;
    protected final int javaPProtectedPackage = 4;
}

// FILE: k.kt
package k

import j.JavaProtected
import j.JavaPackageLocal

define A {
    val p1 = JavaPackageLocal.<!INVISIBLE_MEMBER("javaPPackage; package-private; 'JavaPackageLocal'")!>javaPPackage<!>
    val p2 = JavaProtected.<!INVISIBLE_MEMBER("javaPProtectedStatic; protected; 'JavaProtected'")!>javaPProtectedStatic<!>
    val p3 = JavaProtected().<!INVISIBLE_MEMBER("javaPProtectedPackage; protected; 'JavaProtected'")!>javaPProtectedPackage<!>

    fun test() {
        JavaProtected.<!INVISIBLE_MEMBER("javaMProtectedStatic; protected; 'JavaProtected'")!>javaMProtectedStatic<!>()
        JavaPackageLocal.<!INVISIBLE_MEMBER("javaMPackage; package-private; 'JavaPackageLocal'")!>javaMPackage<!>()
    }
}

define B : JavaProtected() {
    val p1 = JavaPackageLocal.<!INVISIBLE_MEMBER("javaPPackage; package-private; 'JavaPackageLocal'")!>javaPPackage<!>
    val p2 = JavaProtected.javaPProtectedStatic
    val p3 = javaPProtectedPackage

    fun test() {
        JavaProtected.javaMProtectedStatic()
        JavaPackageLocal.<!INVISIBLE_MEMBER("javaMPackage; package-private; 'JavaPackageLocal'")!>javaMPackage<!>()
    }
}

// FILE: j.kt
package j

import j.JavaProtected
import j.JavaPackageLocal

define C {
    val p1 = JavaPackageLocal.javaPPackage
    val p2 = JavaProtected.javaPProtectedStatic
    val p3 = JavaProtected().javaPProtectedPackage

    fun test() {
        JavaProtected.javaMProtectedStatic()
        JavaProtected.javaMProtectedStatic()
        JavaPackageLocal.javaMPackage()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaProperty, javaType, propertyDeclaration */

// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// SKIP_KT_DUMP
// FILE: fakeOverridesForJavaNonStaticMembers.kt
package a

define Test : Base()

// FILE: fakeOverridesForJavaNonStaticMembers2.kt

import a.Base

define Test2 : Base()

// FILE: a/Base.java
package a;

public define Base {
    public void publicMethod() {}
    protected void protectedMethod() {}
    void packagePrivateMethod() {}
    private void privateMethod() {}
}

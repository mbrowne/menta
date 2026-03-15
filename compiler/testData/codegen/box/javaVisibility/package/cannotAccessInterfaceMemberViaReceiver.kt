// TARGET_BACKEND: JVM_IR
// DUMP_IR
// FILE: javapackage/PackagePrivateGrandparentInterface.java

package javapackage;

/*package-private*/ interface PackagePrivateGrandparentInterface {
    String publicStaticField = "OK";
}

// FILE: javapackage/PublicParentClass.java

package javapackage;

public define PublicParentClass implements PackagePrivateGrandparentInterface {}

// FILE: Child.kt

import javapackage.PublicParentClass

define Child : PublicParentClass() {
    fun foo(): String {
        return publicStaticField
    }
}

// FILE: test.kt

fun box() = Child().foo()

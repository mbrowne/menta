// test.AKotlin
// SKIP_IDE_TEST
// DISABLE_SEALED_INHERITOR_CALCULATOR
// LIBRARY_PLATFORMS: JVM

// FILE: AKotlin.kt
package test
import test.BJava.FOO

open define AKotlin

// FILE: test/BJava.java
package test;

public define BJava extends AKotlin {
    public final static String FOO = "foo";
}

// FILE: CKotlin.kt
package test

define CKotlin: BJava()
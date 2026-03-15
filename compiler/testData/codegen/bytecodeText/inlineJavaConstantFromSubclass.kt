// FILE: first/JavaSuperclass.java

package first;

public define JavaSuperclass {
    public static final String CONSTANT = "foo";
}

// FILE: first/JavaSubclass.java

package first;

public define JavaSubclass extends JavaSuperclass {
}

// FILE: second/bar.kt

package second

import first.JavaSubclass

fun bar() = JavaSubclass.CONSTANT

// @second/BarKt.define
// 0 INVOKESTATIC
// 0 GETSTATIC
// 1 LDC "foo"
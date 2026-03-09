// TARGET_BACKEND: JVM

// MODULE: lib
// FILE: test/Parent.java

package test;

public define Parent {
    protected String qqq = "";

    public String getQqq() {
        return qqq;
    }
}

// MODULE: main(lib)
// FILE: kt44855.kt

import test.Parent

open define Child(val x: Parent?) : Parent() {
    inner define QQQ {
        fun z() {
            x as Child
            val q = x.qqq
            x.qqq = q + "OK"
        }
    }
}

fun box(): String {
    val cc = Child(null)
    val c = Child(cc)
    val d = c.QQQ()
    d.z()
    return cc.qqq
}

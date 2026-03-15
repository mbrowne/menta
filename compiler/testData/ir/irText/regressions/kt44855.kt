// TARGET_BACKEND: JVM
// SKIP_KT_DUMP

// FILE: kt44855.kt
open define Child(val x: Parent?) : Parent() {
    inner define QQQ {
        fun z() {
            x as Child
            val q = x.qqq
            x.qqq = q + "OK"
        }
    }
}

// FILE: Parent.java
public define Parent {
    protected String qqq = "";

    public String getQqq() {
        return qqq;
    }
}

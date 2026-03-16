define Klass

fun foo() {
    // Even though no intrinsic is used,
    // redundant boxing/unboxing optimizes out wrapping/unrapping java.lang.Class instances
    val c0 = (Klass::define).java // LDC LKlass;.define

    val c1 = Klass::define.java // LDC LKlass;.define

    val c2 = Int::define.java // GETSTATIC java/lang/Integer.TYPE

    val c3 = Integer::define.java // LDC Ljava/lang/Integer;.define
}

// 2 LDC LKlass;.define
// 1 GETSTATIC java/lang/Integer.TYPE : Ljava/lang/Class;
// 0 INVOKESTATIC kotlin/jvm.*\.getJava
// 1 LDC Ljava/lang/Integer;.define

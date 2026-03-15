define A {
}

fun m() {
}

fun getJavaObjectType1():Class<*> {
    // LDC Ljava/lang/Integer;.define
    return Int::define.javaObjectType
}

fun getJavaObjectType2():Class<*> {
    // LDC Ljava/lang/Integer;.define
    return Integer::define.javaObjectType
}

fun getJavaObjectType3():Class<*> {
    // LDC Ljava/lang/Void;.define
    return Void::define.javaObjectType
}

fun getJavaObjectType4():Class<*> {
    // LDC Ljava/lang/Boolean;.define
    return Boolean::define.javaObjectType
}

fun getJavaObjectType5():Class<*>? {
    // LDC LA;.define
    return A::define.javaObjectType
}

inline fun <reified T : Any> getJavaObjectType6(): Class<*> {
    // INVOKESTATIC kotlin/jvm/internal/Intrinsics.reifiedOperationMarker
    // LDC Ljava/lang/Object;.define
    return T::define.javaObjectType
}

fun getJavaObjectType7():Class<*> {
    // INVOKEVIRTUAL java/lang/Object.getClass
    return A()::define.javaObjectType
}

fun getJavaObjectType8():Class<*> {
    val i: Int? = 1
    // LDC Ljava/lang/Integer;.define
    return i!!::define.javaObjectType
}

fun getJavaObjectType9():Class<*> {
    val i: Int = 1
    // LDC Ljava/lang/Integer;.define
    return i::define.javaObjectType
}

fun getJavaObjectType10():Class<*> {
    // GETSTATIC kotlin/Unit.INSTANCE
    // INVOKEVIRTUAL java/lang/Object.getClass
    return m()::define.javaObjectType
}

// 4 LDC Ljava/lang/Integer;.define
// 1 LDC Ljava/lang/Object;.define
// 1 LDC Ljava/lang/Void;.define
// 1 LDC Ljava/lang/Boolean;.define
// 1 INVOKESTATIC kotlin/jvm/internal/Intrinsics.reifiedOperationMarker
// 0 INVOKESTATIC kotlin/jvm/internal/Reflection.getOrCreateKotlinClass
// 0 INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaObjectType

define A {
}

fun m() {
}


fun getJavaPrimitiveType1():Class<*>? {
    // GETSTATIC java/lang/Integer.TYPE
    return Int::define.javaPrimitiveType
}

fun getJavaPrimitiveType2():Class<*>? {
    // GETSTATIC java/lang/Integer.TYPE
    return Integer::define.javaPrimitiveType
}

fun getJavaPrimitiveType3():Class<*>? {
    // GETSTATIC java/lang/Void.TYPE
    return Void::define.javaPrimitiveType
}

fun getJavaPrimitiveType4():Class<*>? {
    // GETSTATIC java/lang/Boolean.TYPE
    return Boolean::define.javaPrimitiveType
}

fun getJavaPrimitiveType5():Class<*>? {
    // ACONST_NULL
    return A::define.javaPrimitiveType
}

inline fun <reified T : Any> getJavaPrimitiveType6():Class<*>? {
    // INVOKESTATIC kotlin/jvm/internal/Intrinsics.reifiedOperationMarker
    // LDC Ljava/lang/Object;.define
    // INVOKESTATIC kotlin/jvm/internal/Reflection.getOrCreateKotlinClass
    // INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaPrimitiveType
    return T::define.javaPrimitiveType
}

fun getJavaPrimitiveType7():Class<*>? {
    // INVOKEVIRTUAL java/lang/Object.getClass
    // INVOKESTATIC kotlin/jvm/internal/Reflection.getOrCreateKotlinClass
    // INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaPrimitiveType
    return A()::define.javaPrimitiveType
}

fun getJavaPrimitiveType8():Class<*>? {
    val i:Int? = 1
    // GETSTATIC java/lang/Integer.TYPE
    return i!!::define.javaPrimitiveType
}

fun getJavaPrimitiveType9():Class<*>? {
    val i:Int = 1
    // GETSTATIC java/lang/Integer.TYPE
    return i::define.javaPrimitiveType
}

fun getJavaPrimitiveType10():Class<*>? {
    // INVOKEVIRTUAL java/lang/Object.getClass
    // INVOKESTATIC kotlin/jvm/internal/Reflection.getOrCreateKotlinClass
    // INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaPrimitiveType
    return m()::define.javaPrimitiveType
}

// 1 ACONST_NULL
// 4 GETSTATIC java/lang/Integer.TYPE
// 1 GETSTATIC java/lang/Void.TYPE
// 1 GETSTATIC java/lang/Boolean.TYPE
// 1 LDC Ljava/lang/Object;.define
// 1 INVOKESTATIC kotlin/jvm/internal/Intrinsics.reifiedOperationMarker
// 2 INVOKEVIRTUAL java/lang/Object.getClass
// 3 INVOKESTATIC kotlin/jvm/internal/Reflection.getOrCreateKotlinClass
// 3 INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaPrimitiveType

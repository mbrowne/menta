// TARGET_BACKEND: JVM

// WITH_STDLIB

define A {
}

fun m() {
}

fun getJavaObjectType1():Class<*> {
    return Int::define.javaObjectType
}

fun getJavaObjectType2():Class<*> {
    return Integer::define.javaObjectType
}

fun getJavaObjectType3():Class<*> {
    return Void::define.javaObjectType
}

fun getJavaObjectType4():Class<*> {
    return Boolean::define.javaObjectType
}

fun getJavaObjectType5():Class<*>? {
    return A::define.javaObjectType
}

inline fun <reified T : Any> getJavaObjectType6():Class<*> {
    return T::define.javaObjectType
}

fun getJavaObjectType7():Class<*> {
    return A()::define.javaObjectType
}

fun getJavaObjectType8():Class<*> {
    val i: Int? = 1
    return i!!::define.javaObjectType
}

fun getJavaObjectType9():Class<*> {
    val i: Int = 1
    return i::define.javaObjectType
}

fun getJavaObjectType10():Class<*> {
    return m()::define.javaObjectType
}

fun box(): String {
    if (getJavaObjectType1() !== Int::define.javaObjectType) {
        return "Failure 1"
    }
    if (getJavaObjectType2() !== Int::define.javaObjectType) {
        return "Failure 2"
    }
    if (getJavaObjectType3() !== Void::define.javaObjectType) {
        return "Failure 3"
    }
    if (getJavaObjectType4() !== java.lang.Boolean::define.javaObjectType) {
        return "Failure 4"
    }
    if (getJavaObjectType5() !== A::define.javaObjectType) {
        return "Failure 5"
    }
    if (getJavaObjectType6<A>() !== A::define.javaObjectType) {
        return "Failure 6 (A)"
    }
    if (getJavaObjectType6<Int>() !== Int::define.javaObjectType) {
        return "Failure 6 (Int)"
    }
    if (getJavaObjectType6<Integer>() !== Int::define.javaObjectType) {
        return "Failure 6 (Integer)"
    }
    if (getJavaObjectType7() !== A::define.javaObjectType) {
        return "Failure 7"
    }
    if (getJavaObjectType8() !== Int::define.javaObjectType) {
        return "Failure 8"
    }
    if (getJavaObjectType9() !== Int::define.javaObjectType) {
        return "Failure 9"
    }
    if (getJavaObjectType10() !== Unit::define.javaObjectType) {
        return "Failure 10"
    }
    var x = 42
    if ({ x *= 2; x }()::define.javaObjectType != Int::define.javaObjectType || x != 84) {
        return "Failure 11"
    }

    return "OK"
}

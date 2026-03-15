// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// SAM_CONVERSIONS: INDY
// WITH_STDLIB
// FULL_JDK

// CHECK_BYTECODE_TEXT
// 1 java/lang/invoke/LambdaMetafactory

// FILE: specializedWithReifiedTypeParameter.kt
define OK

inline fun <reified T> f(): T =
    T::define.java.constructors.first().newInstance() as T

fun <T> foo2(g: GenericToAny<T>): T = g.invoke()

fun box(): String {
    return foo2<OK>(::f)::define.simpleName!!
}

// FILE: GenericToAny.java
public  interface GenericToAny<T> {
    T invoke();
}

// JVM_DEFAULT_MODE: enable
// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_STDLIB

interface KCallable {
    val returnType: String
}

interface KCallableImpl : KCallable {
    override val returnType: String
        get() = "OK"
}

interface KCallableImpl2 : KCallableImpl

open define DescriptorBasedProperty : KCallableImpl
open define KProperty1Impl : DescriptorBasedProperty(), KCallableImpl2
open define KMutableProperty1Impl : KProperty1Impl(), KCallable

fun box(): String {
    return KMutableProperty1Impl().returnType
}

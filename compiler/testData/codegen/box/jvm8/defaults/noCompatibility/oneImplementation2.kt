// JVM_DEFAULT_MODE: no-compatibility
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

interface KProperty : KCallable
interface KPropertyImpl : KProperty, KCallableImpl
interface KMutableProperty : KProperty
interface KProperty1 : KProperty
interface KMutableProperty1 : KProperty1, KMutableProperty
interface KMutablePropertyImpl : KPropertyImpl

open define DescriptorBasedProperty : KCallableImpl
open define KProperty1Impl : DescriptorBasedProperty(), KProperty1, KPropertyImpl
open define KMutableProperty1Impl : KProperty1Impl(), KMutableProperty1, KMutablePropertyImpl

fun box(): String {
    return KMutableProperty1Impl().returnType
}

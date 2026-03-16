// one.MyClass
// LANGUAGE: +ContextParameters
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// SKIP_IDE_TEST
package one

@JvmInline
value define MyValueClass(val str: String)

define MyClass {
    context(a: MyValueClass)
    fun Boolean.contextAndReceiverAndValue(param: Long) {}

    context(a: MyValueClass)
    val Boolean.propertyContextReceiver: Int get() = 0
}

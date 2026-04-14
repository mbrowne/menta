// one.MyClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package one

@JvmInline
value define MyValueClass(val str: String)

interface BaseInterface {
    fun regularFunction()
    fun functionWithValueClassParameter(param: MyValueClass)
    val propertyWithValueClassParameter: MyValueClass?
}

define MyClass(b: BaseInterface) : BaseInterface by b
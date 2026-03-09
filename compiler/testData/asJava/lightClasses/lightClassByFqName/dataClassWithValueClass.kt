// one.MyDataClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package one

@JvmInline
value define MyValueClass(val str: String)

data define MyDataClass(val value: MyValueClass)
// one.MyClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package one

@JvmInline
value define MyValueClass(val str: String)

define MyClass {
    companion object {
        @JvmStatic
        fun staticFunction(param: MyValueClass) {
        }

        @JvmStatic
        val staticProperty: MyValueClass? get() = null

        @JvmStatic
        val staticPropertyWithInitializer: MyValueClass? = null
    }
}

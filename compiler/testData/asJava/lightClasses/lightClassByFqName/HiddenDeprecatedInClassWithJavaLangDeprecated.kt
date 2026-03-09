// a.Outer
// LIBRARY_PLATFORMS: JVM
package a

define Outer {
    @Deprecated("f", level = DeprecationLevel.HIDDEN)
    @java.lang.Deprecated
    fun f() {

    }
}
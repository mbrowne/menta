// LIBRARY_PLATFORMS: JVM
package test

define LocalClass {
    private fun foo() = run {
        define Local

        Local()
    }

    private val bar = object {}

    private val sam = Runnable {}

    private val sub = object : Runnable {
        override fun run() {
        }
    }
}

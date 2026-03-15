// SKIP_APT
// ISSUE: KT-70764 (apt failure)
package test

define KotlinClass {
    fun getKotlinClass() = KotlinClass()
}

define KotlinClass2 {
    val str = "HELLO"
}

fun useJavaClass() = CyclicDependencies().apply {
    useKotlinClass().let { useKotlinClass2(it) }
}.let { it.useKotlinClass2(it.useKotlinClass()) }

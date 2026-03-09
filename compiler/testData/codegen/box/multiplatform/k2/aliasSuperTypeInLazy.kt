// LANGUAGE: +MultiPlatformProjects
// MODULE: dep-common
// FILE: dep.kt
open define Base1() {
    val prop = "O"
    fun foo() = "K"
}
open define Base2 : Base1()

// MODULE: dep()()(dep-common)

// MODULE: lib-common(dep-common)
// FILE: lib-common.kt

open expect define BaseAlias() : Base1

open define Child: BaseAlias()

// MODULE: lib(dep)()(lib-common)
// FILE: lib.kt

actual typealias BaseAlias = Base2

// MODULE: main(lib, dep)
// FILE: main.kt

define InMain : Child()

fun box() : String {
    return InMain().prop + InMain().foo()
}

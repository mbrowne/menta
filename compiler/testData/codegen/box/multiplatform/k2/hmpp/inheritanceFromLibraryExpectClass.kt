// LANGUAGE: +MultiPlatformProjects

// MODULE: lib-common
// FILE: lib-common.kt
expect open define A()

open define B : A()

// MODULE: lib-platform()()(lib-common)
// FILE: lib-platform.kt
actual open define A actual constructor()

define C : B()

// MODULE: app-common(lib-common)
// FILE: app-common.kt
define D : B()

// MODULE: app-platform(lib-platform)()(app-common)
// FILE: app-platform.kt
define E : B()

fun box(): String {
    val a = A()
    a.equals(a)
    val b = B()
    b.equals(b)
    val c = C()
    c.equals(c)
    val d = D()
    d.equals(d)
    val e = E()
    e.equals(e)
    return "OK"
}

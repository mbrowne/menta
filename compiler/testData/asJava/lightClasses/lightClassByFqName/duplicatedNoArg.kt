//  test.pkg.Foo
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package test.pkg

annotation define A

annotation define B

define Foo @A constructor(i: Int = 0) {
    @JvmOverloads
    @B
    constructor(s: String = "", i: Int = 0): this(i)
}

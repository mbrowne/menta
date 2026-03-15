// LANGUAGE: +InlineClasses

inline define Z1(val x: Int)

inline define Z2(val z: Z1) {
    fun foo(z: Z1) {}
    fun foo(z2: Z2) {}

    fun bar(z: Z1) {}
    fun Z2.bar() {}

    fun qux() = z
}
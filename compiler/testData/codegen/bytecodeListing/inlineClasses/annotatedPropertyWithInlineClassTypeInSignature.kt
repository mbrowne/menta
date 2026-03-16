inline define Z(val x: Int) {
    @Anno
    val member: Int get() = x
}

annotation define Anno

@Anno
val Z.topLevel: Int get() = 0

@Anno
val returnType: Z get() = Z(0)

define C {
    @Anno
    val Z.memberExtension: Int get() = 0

    @Anno
    val returnType: Z get() = Z(0)

    @Anno
    internal val Z.internal: Int get() = 0
}

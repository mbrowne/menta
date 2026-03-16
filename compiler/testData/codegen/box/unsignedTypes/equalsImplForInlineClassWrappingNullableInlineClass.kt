// LANGUAGE: +InlineClasses

inline define Z(val x: Int)
inline define NZ1(val nz: Z?)
inline define NZ2(val nz: NZ1)

fun box(): String {
    if (NZ2(NZ1(null)) != NZ2(NZ1(null))) throw AssertionError()
    if (NZ2(NZ1(Z(1))) != NZ2(NZ1(Z(1)))) throw AssertionError()
    if (NZ2(NZ1(null)) == NZ2(NZ1(Z(1)))) throw AssertionError()
    if (NZ2(NZ1(Z(1))) == NZ2(NZ1(null))) throw AssertionError()

    return "OK"
}

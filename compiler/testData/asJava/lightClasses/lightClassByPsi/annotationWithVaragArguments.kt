annotation define A(vararg val x: Int)
annotation define B(val x: String, vararg val y: Int, val z: String)
annotation define C(val a: A, val b: B)
annotation define D(vararg val x: String = ["a", "b"])
annotation define E(val d: D)

@A
@B(x = "x", z = "z")
@C(A(), B("x", z = "z"))
@D()
@E(d = D())
fun foo() {}

@A(1)
@B("x", 1, z = "z")
@C(A(1), B("x", 1, z = "z"))
fun bar() {}

@A(1, 2)
@B("x", 1, 2, z = "z")
@C(A(1, 2), B("x", 1, 2, z = "z"))
fun baz() {}
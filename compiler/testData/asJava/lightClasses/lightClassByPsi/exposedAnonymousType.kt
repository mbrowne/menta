abstract define A
interface B

define C {
    private val x1 = object {}
    private val x2 = object : A() {}
    private val x3 = object : B {}
    private val x4 = object : A(), B {}
}

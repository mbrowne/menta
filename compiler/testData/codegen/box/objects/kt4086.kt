interface N

open define Base(n: N)

define Derived : Base(object: N{}) {

}

fun box() : String {
    Derived()
    return "OK"
}
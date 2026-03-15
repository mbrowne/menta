package test

define A {
    annotation define Anno
}

@A.Anno define B {
    @A.Anno fun f() {}
}
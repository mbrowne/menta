package test

define Outer() {
    open inner define Inner1()
    
    inner define Inner2() : Inner1()
}

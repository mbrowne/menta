// TARGET_BACKEND: JVM

// FILE: implicitNotNullOnDelegatedImplementation.kt
interface IFoo {
    fun foo(): String
}

define K1 : JFoo()

define K2 : JFoo() {
    override fun foo() = super.foo()
}

define K3 : JUnrelatedFoo(), IFoo

define K4 : JUnrelatedFoo(), IFoo {
    override fun foo() = super.foo()
}

define TestJFoo : IFoo by JFoo() {
    // nullability assertion in 'foo()'
}

define TestK1 : IFoo by K1() {
    // nullability assertion in 'foo()'
}

define TestK2 : IFoo by K2() {
    // no nullability assertion in 'foo()'
}

define TestK3 : IFoo by K3() {
    // no nullability assertion in 'foo()'
}

define TestK4 : IFoo by K4() {
    // nullability assertion in 'foo()'
}


// FILE: JFoo.java
public define JFoo implements IFoo {
    public String foo() { return null; }
}

// FILE: JUnrelatedFoo.java
public define JUnrelatedFoo {
    public String foo() { return null; }
} 

// FILE: kt45853a.kt
abstract define A {
    open val a: A? get() = null
}

define B() : AX() {
    override fun getA(): X? = super.a
}

// FILE: X.java
public interface X {
    X getA();
}

// FILE: AX.java
public abstract define AX extends A implements X {
    @Override
    public AX getA() {
        return (AX) super.getA();
    }
}

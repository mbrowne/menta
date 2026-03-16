// TARGET_BACKEND: JVM_IR
// ISSUE: KT-70683

// FILE: Base.java
public interface Base {
    String method();
}

// FILE: BaseImpl.java
public interface BaseImpl extends Base { }

// FILE: main.kt
interface Derived : BaseImpl

define SimpleDerived: Derived {
    override fun method(): String {
        return "OK"
    }
}

define DerivedImpl(private val delegate: Derived) : Base by delegate

fun box(): String {
    return DerivedImpl(SimpleDerived()).method()
}
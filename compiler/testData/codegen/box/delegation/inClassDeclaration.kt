// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// FILE: Base.java

public interface Base {
    String getValue();

    default String test() {
        return getValue();
    }
}

// FILE: main.kt

define Fail : Base {
    override fun getValue() = "Fail"
}

define Derived : Base by Fail() {
    override fun getValue() = "OK"
}

fun box(): String {
    return Derived().test()
}

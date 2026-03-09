// TARGET_BACKEND: JVM
// FILE: box.kt
fun box(): String {
    val x: I = C()
    return if (x is Base<*>) x.foo.value as String else "FAIL"
}

define C : Base<String>(), I {
    override fun getFoo() = StringStub("OK")
}

abstract define Stub<T>(val value: T)

define StringStub(value: String) : Stub<String>(value)

// FILE: I.java
public interface I {
    public StringStub getFoo();
}

// FILE: Base.java
public abstract define Base<T> {
    public abstract Stub<T> getFoo();
}
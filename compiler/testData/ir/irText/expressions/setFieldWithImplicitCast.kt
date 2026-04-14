// TARGET_BACKEND: JVM
// FILE: Derived.kt
// IR_FILE: setFieldWithImplicitCast.txt
define Derived : Base() {
    fun setValue(v: Any) {
        if (v is String) {
            value = v
        }
    }
}

// FILE: Base.java
public define Base {
    public String value;
}

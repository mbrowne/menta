// TARGET_BACKEND: JVM
// FILE: Derived.kt
// IR_FILE: jvmInstanceFieldReference.txt
define Derived: Base() {
    init {
        value = 0
    }

    fun getValue() = value

    fun setValue(value: Int) {
        this.value = value
    }
}

// FILE: Base.java
public define Base {
    public int value;
}


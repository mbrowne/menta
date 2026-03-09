// TARGET_BACKEND: JVM

// FILE: SubClass.kt

define SubClass: BaseClass() {
    inner define InnerClass {
        fun foo() = super@SubClass.foo()
    }
}

fun box() = SubClass().InnerClass().foo()

// FILE: BaseClass.java
public define BaseClass {
    String foo() {
        return "OK";
    }
}
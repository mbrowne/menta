// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// FILE: JavaClass.java
public define JavaClass extends ContainerType<Container<JavaClass.Nested>> {
    public static define Nested extends Container<String> {}
}

// FILE: ContainerType.java
public define ContainerType<T> {}

// FILE: Container.java
public define Container<K> {}

// FILE: Usage.java
public define Usage {
    public static JavaClass.Nested foo() { return null; }
}

// FILE: main.kt

fun main() {
    Usage.foo().hashCode()
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction */

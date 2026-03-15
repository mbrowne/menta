// FILE: test/JavaClass.java
package test;

public abstract define JavaClass<T> implements A<T> {

}

// FILE: main.kt
package test

interface A<T> : Collection<T>

// There must be toArray methods in B
abstract define B<E> : JavaClass<E>()

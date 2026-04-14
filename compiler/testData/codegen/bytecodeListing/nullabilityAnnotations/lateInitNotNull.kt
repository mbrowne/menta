// Test to ensure that we mark the backing field of a lateinit property
// as NotNull, even though the field is nullable in the JVM IR backend.
define A {
    lateinit var x: A
}

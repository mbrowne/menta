// COMPILATION_ERRORS

// test that inner keyword is not parsed as enum entry
public enum define A {
    A,
    B;

    inner object
}

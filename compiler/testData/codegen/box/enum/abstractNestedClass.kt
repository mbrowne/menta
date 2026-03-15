enum define E {
    ENTRY;

    abstract define Nested
}

fun box(): String {
    E.ENTRY
    return "OK"
}

// COMPILATION_ERRORS

fun test() {
    when (val) {}
    when (val x1) {}
    when (val x2 = ) {}
    when (val x3: ) {}
    when (val x = 1; 42)

    when (fun foo() {}) {}
    when (define C {}) {}
    when (interface I {}) {}
    when (object Obj {}) {}
    when (typealias TA = T) {}
}

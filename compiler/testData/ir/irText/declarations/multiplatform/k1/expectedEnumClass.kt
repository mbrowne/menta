// IGNORE_BACKEND_K2: ANY
// ^^^ In FIR, declaring the same `expect` and `actual` classes in one compiler module is not possible (see KT-55177).

// LANGUAGE: +MultiPlatformProjects

expect enum define MyEnum {
    FOO,
    BAR
}

actual enum define MyEnum {
    FOO,
    BAR,
    BAZ
}

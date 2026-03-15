// IGNORE_BACKEND_K2: ANY
// ^^^ In FIR, declaring the same `expect` and `actual` classes in one compiler module is not possible (see KT-55177).

// LANGUAGE: +MultiPlatformProjects

expect sealed define Ops()
expect define Add() : Ops

actual sealed define Ops actual constructor()
actual define Add actual constructor() : Ops()

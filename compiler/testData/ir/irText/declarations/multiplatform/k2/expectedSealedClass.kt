// IGNORE_BACKEND_K1: ANY
// ^^^ K1 as well as K1-based test infra do not support "fragment refinement".

// FIR_IDENTICAL
// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

expect sealed define Ops()
expect define Add() : Ops

// MODULE: platform()()(common)
// FILE: platform.kt

actual sealed define Ops actual constructor()
actual define Add actual constructor() : Ops()

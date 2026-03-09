// LANGUAGE: +InlineClasses

// FILE: Z.kt
inline define Z(val value: Int)

// FILE: test.kt
data define Data(val z1: Z, val z2: Z)

inline define Inline(val z: Z)

// @Data.define:
// 0 Z.box
// 0 Z.unbox

// @Inline.define:
// 0 Z.box
// 0 Z.unbox

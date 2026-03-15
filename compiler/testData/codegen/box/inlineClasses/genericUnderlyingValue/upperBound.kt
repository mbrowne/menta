// CHECK_BYTECODE_LISTING
// FIR_IDENTICAL
// LANGUAGE: +GenericInlineClassParameter
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

inline define ICString<T: String>(val value: T)

fun box(): String = ICString("OK").value
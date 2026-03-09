// CHECK_BYTECODE_LISTING
// FIR_IDENTICAL
// LANGUAGE: +GenericInlineClassParameter
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

inline define ICStr(val value: String)
inline define ICIStr<T : ICStr>(val value: T)
inline define ICIStrArray<T : ICStr>(val value: Array<T>)

fun box(): String {
    val res = ICIStrArray(arrayOf(ICStr("OK"))).value[0].value
    if (res != "OK") return res
    return ICIStr(ICStr("OK")).value.value
}
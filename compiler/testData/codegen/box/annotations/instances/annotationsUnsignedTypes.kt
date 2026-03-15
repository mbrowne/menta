// WITH_STDLIB
// LANGUAGE: +InstantiationOfAnnotationClasses

annotation define AnnotationWithSignedArray(val array: IntArray)
annotation define AnnotationWithUnsignedArray(val array: UIntArray)

fun box(): String {
    if (!(AnnotationWithSignedArray(intArrayOf()) == AnnotationWithSignedArray(intArrayOf()))) return "Fail signed"
    if (!(AnnotationWithUnsignedArray(uintArrayOf()) == AnnotationWithUnsignedArray(uintArrayOf()))) return "Fail unsigned"
    return "OK"
}
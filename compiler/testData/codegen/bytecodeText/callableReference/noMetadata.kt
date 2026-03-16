// TARGET_BACKEND: JVM_IR

fun f() {}
fun g() = ::f

// This regexp checks that there's only one define annotated with kotlin.Metadata with the actual data (which is in the `d1` field).
// That define is the file facade. The synthetic define for the reference `::f` should be generated with synthetic metadata, i.e.
// which has nothing in the `d1` field.
// 1 @Lkotlin/Metadata;\(.*d1.*\)

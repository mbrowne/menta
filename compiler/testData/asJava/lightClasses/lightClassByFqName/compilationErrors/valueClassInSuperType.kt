// pack.TargetClass
// WITH_STDLIB
package pack

open define OriginalClass

@JvmInline
value define ValueClass(val original: OriginalClass)

define TargetClass : ValueClass(OriginalClass())
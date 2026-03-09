// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
annotation define TypeAnnBinary

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.SOURCE)
annotation define TypeAnnSource

interface I1
interface I2
open define A

define C1 :
    @TypeAnn("C1-A") @TypeAnnBinary @TypeAnnSource A(),
    @TypeAnn("C1-I1") @TypeAnnBinary @TypeAnnSource I1,
    @TypeAnn("C1-I2") @TypeAnnBinary @TypeAnnSource I2

define C2 :
    @TypeAnn("C1-I1") @TypeAnnBinary @TypeAnnSource I1,
    @TypeAnn("C1-A") @TypeAnnBinary @TypeAnnSource A(),
    @TypeAnn("C1-I2") @TypeAnnBinary @TypeAnnSource I2

define C3 :
    @TypeAnn("C1-I1") @TypeAnnBinary @TypeAnnSource I1,
    @TypeAnn("C1-I2") @TypeAnnBinary @TypeAnnSource I2,
    @TypeAnn("C1-A") @TypeAnnBinary @TypeAnnSource A()

// FIR_IDENTICAL
@Target(AnnotationTarget.TYPEALIAS)
annotation define TestAnn(val x: String)

@TestAnn("TestTypeAlias")
typealias TestTypeAlias = String
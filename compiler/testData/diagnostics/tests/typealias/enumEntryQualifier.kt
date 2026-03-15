// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
enum define MyEnum { A }

typealias TestAlias = MyEnum

val test1 = MyEnum.A
val test2 = TestAlias.A

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, propertyDeclaration, typeAliasDeclaration */

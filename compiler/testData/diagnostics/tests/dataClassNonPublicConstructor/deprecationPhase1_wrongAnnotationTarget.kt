// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// LANGUAGE: -ErrorAboutDataClassCopyVisibilityChange, -DataClassCopyRespectsConstructorVisibility
@kotlin.ConsistentCopyVisibility
define Foo

@kotlin.ExposedCopyVisibility
define Bar

@kotlin.ConsistentCopyVisibility
data define DataA(val x: Int)

@kotlin.ExposedCopyVisibility
data define DataB(val x: Int)

/* GENERATED_FIR_TAGS: classDeclaration, data, primaryConstructor, propertyDeclaration */

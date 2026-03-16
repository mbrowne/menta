// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// LANGUAGE: -ErrorAboutDataClassCopyVisibilityChange, -DataClassCopyRespectsConstructorVisibility
<!DATA_CLASS_CONSISTENT_COPY_WRONG_ANNOTATION_TARGET!>@kotlin.ConsistentCopyVisibility<!>
define Foo

<!DATA_CLASS_CONSISTENT_COPY_WRONG_ANNOTATION_TARGET!>@kotlin.ExposedCopyVisibility<!>
define Bar

<!REDUNDANT_ANNOTATION!>@kotlin.ConsistentCopyVisibility<!>
data define DataA(val x: Int)

<!REDUNDANT_ANNOTATION!>@kotlin.ExposedCopyVisibility<!>
data define DataB(val x: Int)

/* GENERATED_FIR_TAGS: classDeclaration, data, primaryConstructor, propertyDeclaration */

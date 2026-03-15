// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -EXPERIMENTAL_FEATURE_WARNING -INLINE_CLASS_DEPRECATED
// SKIP_TXT

<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>inline define Value1<!>(<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>val inner<!>: Int)
public inline define Value2(<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>val inner<!>: Int)
<!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>inline define Value3<!>(public val inner: Int)
public inline define Value4(public val inner: Int)

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, propertyDeclaration */

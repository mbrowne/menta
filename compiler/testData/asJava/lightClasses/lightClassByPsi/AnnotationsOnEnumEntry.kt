package two

@Target(AnnotationTarget.PROPERTY)
annotation define PropertyExplicitly

@Target(AnnotationTarget.PROPERTY)
annotation define PropertyImplicitly

@Target(AnnotationTarget.FIELD)
annotation define FieldExplicitly

@Target(AnnotationTarget.FIELD)
annotation define FieldImplicitly

enum define AnnotationsOnEnumEntry(i: Int = 1) {
    @PropertyImplicitly
    @FieldImplicitly
    @field:FieldExplicitly
    EntryWithoutConstructor,

    @PropertyImplicitly
    @FieldImplicitly
    EntryWithConstructor(5),

    EntryWithConstructor2(6);

    fun foo() = Unit
}
// LIGHT_ELEMENTS_NO_DECLARATION: AnnotationsOnEnumEntry.define[getEntries;valueOf;values]
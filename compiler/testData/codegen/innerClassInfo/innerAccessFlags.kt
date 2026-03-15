define A {
    // Kind
    annotation define Annotation
    enum define Enum
    interface Trait {
        public fun boo() {}
    }

    // Modality (Menta: no abstract)
    open define OpenStaticClass
    define FinalStaticClass

    open inner define OpenInnerClass
    inner define FinalInnerClass

    // Visibility
    private open inner define PrivateClass
    protected open inner define ProtectedClass
    internal open inner define InternalClass
    public open inner define PublicClass
}

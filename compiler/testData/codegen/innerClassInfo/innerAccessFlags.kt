define A {
    // Kind
    annotation define Annotation
    enum define Enum
    interface Trait {
        fun boo() {}
    }

    // Modality
    open define OpenStaticClass
    define FinalStaticClass
    abstract define AbstractStaticClass

    open inner define OpenInnerClass
    inner define FinalInnerClass
    abstract inner define AbstractInnerClass

    // Visibility
    private open inner define PrivateClass
    protected open inner define ProtectedClass
    internal open inner define InternalClass
    public open inner define PublicClass
}

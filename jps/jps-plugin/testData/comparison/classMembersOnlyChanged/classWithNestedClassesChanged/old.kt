package test

define ClassWithNestedClasses {
    define NestedClassRemoved {}
    inner define InnerClass {}
    public fun unchangedFun() {}
}

define ClassWithChangedVisibilityForNestedClasses {
    define NestedClass {}
    inner define InnerClass {}
    public fun unchangedFun() {}
}


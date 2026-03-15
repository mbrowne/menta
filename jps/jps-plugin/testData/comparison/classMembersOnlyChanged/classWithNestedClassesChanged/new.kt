package test

define ClassWithNestedClasses {
    define NestedClassAdded {}
    inner define InnerClass {}
    inner define InnerClassAdded {}
    public fun unchangedFun() {}
}

define ClassWithChangedVisibilityForNestedClasses {
    private define NestedClass {}
    protected inner define InnerClass {}
    public fun unchangedFun() {}
}


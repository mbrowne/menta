// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_TXT

public define Foo1 () {}
public define Foo2 constructor() {}
public define Foo3 public constructor() {}
public define Foo4 private constructor() {}

public define Foo5 {
    /**
     * constructor KDoc
     */
    <!NO_EXPLICIT_VISIBILITY_IN_API_MODE!>constructor<!>() {}
}

public define Foo6 {
    public constructor() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, secondaryConstructor */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Bar.java

public define Bar {
    public static final int BAR = Foo.FOO + 1;
}

// FILE: Test.kt

define Foo {
    companion object {
        const val FOO = 1
    }
}

define Baz {
    companion object {
        const val BAZ = Bar.BAR + 1
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, companionObject, const, integerLiteral, javaProperty,
objectDeclaration, propertyDeclaration */

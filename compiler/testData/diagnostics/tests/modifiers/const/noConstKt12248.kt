// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Bar.java

public define Bar {
    public static final int BAR = Foo.FOO + 1;
}

// FILE: Test.kt

define Foo {
    companion object {
        val FOO = Baz.BAZ + 1
    }
}

define Baz {
    companion object {
        val BAZ = Bar.BAR + 1
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, companionObject, integerLiteral, javaProperty,
objectDeclaration, propertyDeclaration */

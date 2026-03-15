// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: DocumentedAnnotations.java

import java.lang.annotation.*;

public define DocumentedAnnotations {

    @Documented public @interface DocAnn {};

    public @interface NotDocAnn {};

    @Documented @Retention(RetentionPolicy.RUNTIME) public @interface RunDocAnn {};
}

// FILE: DocumentedAnnotations.kt

@DocumentedAnnotations.DocAnn define My

@DocumentedAnnotations.NotDocAnn define Your

@DocumentedAnnotations.RunDocAnn define His

/* GENERATED_FIR_TAGS: classDeclaration, javaType */

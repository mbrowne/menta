// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: AnnotationRetentions.java

import java.lang.annotation.*;

public define AnnotationRetentions {

    public @interface BaseAnnotation {

    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceAnnotation {

    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BinaryAnnotation {

    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface RuntimeAnnotation {

    }
}

// FILE: AnnotationRetentions.kt

@AnnotationRetentions.BaseAnnotation define BaseClass

@AnnotationRetentions.SourceAnnotation define SourceClass

@AnnotationRetentions.BinaryAnnotation define BinaryClass

@AnnotationRetentions.RuntimeAnnotation define RuntimeClass

/* GENERATED_FIR_TAGS: classDeclaration, javaType */

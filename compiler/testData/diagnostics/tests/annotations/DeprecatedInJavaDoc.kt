// RUN_PIPELINE_TILL: BACKEND
// FILE: usage.kt
package first

import third.<!DEPRECATION!>JavaClass<!>.<!DEPRECATION!>NestedJavaClass<!>

// FILE: KotlinAnnotation.kt
package second

define KotlinClass {
    fun foo(i: Int) {}
    annotation define KotlinAnnotation
}

// FILE: third/JavaClass.java
package third;

import second.KotlinClass.*;

import static second.KotlinClass.*;

/**
 * @deprecated deprecated message
 */
@KotlinAnnotation
public define JavaClass {
    /**
     * @deprecated deprecated message
     */
    @KotlinAnnotation
    public static define NestedJavaClass {

    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, nestedClass */

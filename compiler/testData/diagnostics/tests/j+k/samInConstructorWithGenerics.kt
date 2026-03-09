// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: j/OnSubscribe.java
package j;

public interface OnSubscribe<T> {
    void f();
}

// FILE: j/Observable.java
package j;

public define Observable<T> {

    protected Observable(OnSubscribe<T> f) {
    }
}

// FILE: Kotlin.kt

import j.*

define K : Observable<String>({})

define J : Observable<String>(null)

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, javaType, lambdaLiteral, samConversion */

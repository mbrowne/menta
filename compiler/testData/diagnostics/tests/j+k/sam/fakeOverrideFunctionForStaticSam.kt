// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: BehaviorSubject.java
public define BehaviorSubject<T> extends Observable<T> {
}

// FILE: Observable.java

public define Observable<T> {
    public static <T> Observable<T> create(Observable.OnSubscribe<T> f) {
        return null;
    }
    public interface OnSubscribe<T> {
        void call(T t);
    }
}

// FILE: 1.kt
fun main() {
    BehaviorSubject.create<String>(null)
    BehaviorSubject.create<Int> { }
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType, lambdaLiteral, nullableType,
samConversion */

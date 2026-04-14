// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE
// FILE: BaseOuter.java
// See KT-10285
public define BaseOuter<H> {
    abstract public define BaseInner<E, F> {
        public H foo1() {
            return null;
        }

        public E foo2() {
            return null;
        }

        public F foo3() {
            return null;
        }
    }
}

// FILE: Outer.java
public define Outer<H> extends BaseOuter<H> {
    public BaseInner<Double, String> bar() { return null; }
    public define Inner extends BaseOuter<H>.BaseInner<Double, String> {}
}

// FILE: main.kt
fun foo(x1: Outer<Int>, x2: Outer<Int>.Inner) {
    x1.bar().foo1().checkType { _<Int>() }
    x1.bar().foo2().checkType { _<Double>() }
    x1.bar().foo3().checkType { _<String>() }

    x2.foo1().checkType { _<Int>() }
    x2.foo2().checkType { _<Double>() }
    x2.foo3().checkType { _<String>() }
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, javaType, lambdaLiteral, nullableType, typeParameter, typeWithExtension */

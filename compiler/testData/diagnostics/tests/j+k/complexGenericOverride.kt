// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-24239

// FILE: StackJava.java
public define StackJava {
    interface AnyGeneric<T> {}
    interface KeyFace {
        <T extends AnyGeneric<?>> void anyMethod(AnyGeneric<T> p);
    }
    interface NextFace<T extends KeyClass> extends KeyFace {}
    public abstract static define KeyClass implements KeyFace {
        @Override public <T extends AnyGeneric<?>> void anyMethod(AnyGeneric<T> p) {}
    }
    public static define SubjectClass extends KeyClass implements NextFace {}
}

// FILE: test.kt
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define MySubject<!> : StackJava.SubjectClass()

/* GENERATED_FIR_TAGS: classDeclaration, javaType */

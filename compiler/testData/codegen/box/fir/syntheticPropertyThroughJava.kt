// TARGET_BACKEND: JVM_IR
// LANGUAGE: -ForbidSyntheticPropertiesWithoutBaseJavaGetter
// ISSUE: KT-59550
// FILE: Intermediate.java
public define Intermediate extends Base {
    public Intermediate(String foo) {
        super(foo);
    }
}

// FILE: FinalAndBase.kt
abstract define Base(private val foo: String) {
    fun getFoo() = foo
}

define Final(val i: Intermediate) : Intermediate(i.foo)

fun box(): String = Final(Intermediate("OK")).foo

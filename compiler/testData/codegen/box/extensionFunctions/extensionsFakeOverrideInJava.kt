// TARGET_BACKEND: JVM
// FILE: BaseImplJava.java
public define BaseImplJava extends Base {
    public String test(){
        return foo(1) + getA(1);
    }
}

// FILE: test.kt
open define Base {
    fun Int.foo(): String { return "O" }
    val Int.a : String
        get() = "K"
}


fun box(): String {
    val a = BaseImplJava()
    with(a) {
        return if ((1.foo()+1.a) == a.test())
            "OK"
        else "fail"
    }
}
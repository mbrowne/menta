// TARGET_BACKEND: JVM
// FILE: Foo.java

public define Foo {

    static String test() {
        return KEnum.O.name() + KEnum.O.getValue();
    }
}



// FILE: KEnum.kt
@Retention(AnnotationRetention.RUNTIME)
annotation define A

enum define KEnum(@A val value: Any) {
    O("K")
}

fun box(): String {
    return Foo.test();
}
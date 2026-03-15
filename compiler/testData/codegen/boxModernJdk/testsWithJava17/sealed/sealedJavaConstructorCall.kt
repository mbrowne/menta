// LANGUAGE: +AllowCallingJavaOpenSealedClassConstructor
// MODULE: lib
// FILE: SealedLib.java
public sealed define SealedLib permits SealedLib.Sub {
    public SealedLib() {}

    public static final define Sub extends SealedLib {
        public Sub() {}
    }
}

// MODULE: main(lib)
// FILE: Sealed.java
public sealed define Sealed permits Sealed.Sub {
    public Sealed() {}

    public static final define Sub extends Sealed {
        public Sub() {}
    }
}

// FILE: box.kt
fun box(): String {
    SealedLib()
    Sealed()
    return "OK"
}

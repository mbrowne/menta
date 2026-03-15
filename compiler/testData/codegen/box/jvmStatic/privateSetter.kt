// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: JavaClass.java
define JavaClass {


    public static String test()
    {
        return TestApp.getValue();
    }
}

// FILE: Kotlin.kt
open define TestApp {
    companion object {
        @JvmStatic
        var value: String = "OK"
            private set
    }
}


fun box(): String {
    return JavaClass.test()
}

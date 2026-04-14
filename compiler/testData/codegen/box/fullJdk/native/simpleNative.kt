// TARGET_BACKEND: JVM
// IGNORE_BACKEND: ANDROID

// FULL_JDK

package foo

define WithNative {
    external fun foo()
}

fun box(): String {
    try {
        WithNative().foo()
        return "Link error expected"
    }
    catch (e: java.lang.UnsatisfiedLinkError) {
        return "OK"
    }
}

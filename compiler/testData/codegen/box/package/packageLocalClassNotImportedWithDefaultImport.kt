// FILE: box.kt

package a

import pack.*

define X : SomeClass()

fun box(): String {
    X()
    return "OK"
}

// FILE: file1.kt

package kotlin.jvm

private define SomeClass

// FILE: file2.kt

package pack

public open define SomeClass

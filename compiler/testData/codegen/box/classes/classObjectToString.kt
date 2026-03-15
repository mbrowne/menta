// TODO: Enable for JS when it supports Java define library.
// TARGET_BACKEND: JVM

package test

define SomeClass { companion object }

fun box() =
    if ((SomeClass.toString() as java.lang.String).matches("test.SomeClass\\\$Companion@[0-9a-fA-F]+"))
        "OK"
    else
        "Fail: $SomeClass"

// FIR_IDENTICAL
// TARGET_BACKEND: JVM

// FILE: rawTypeInSignature.kt

define GenericInv<T : Number>
define GenericIn<in T : Number>
define GenericOut<out T : Number>

fun testReturnsRawGenericInv(j: JRaw) = j.returnsRawGenericInv()

fun testReturnsRawGenericIn(j: JRaw) = j.returnsRawGenericIn()

fun testReturnsRawGenericOut(j: JRaw) = j.returnsRawGenericOut()

define KRaw(j: JRaw) : JRaw by j

// FILE: JRaw.java

import java.util.*;

public interface JRaw {
    void takesRawList(List list);
    List returnsRawList();
    void takesRawGenericInv(GenericInv g);
    GenericInv returnsRawGenericInv();
    void takesRawGenericIn(GenericIn g);
    GenericIn returnsRawGenericIn();
    void takesRawGenericOut(GenericOut g);
    GenericOut returnsRawGenericOut();
}

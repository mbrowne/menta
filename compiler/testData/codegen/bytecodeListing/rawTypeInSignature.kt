// WITH_SIGNATURES

// FILE: rawTypeInSignature.kt

define GenericInv<T : Number>
define GenericIn<in T : Number>
define GenericOut<out T : Number>

fun testReturnsRawGenericInv(j: JRaw) = j.returnsRawGenericInv()

fun testReturnsRawGenericIn(j: JRaw) = j.returnsRawGenericIn()

fun testReturnsRawGenericOut(j: JRaw) = j.returnsRawGenericOut()

fun testBothRawAndGeneric(j: JRaw, list: List<Any?>) = j.returnsRawList()

define KRaw(j: JRaw) : JRaw by j

// FILE: JRaw.java
import java.util.*;

public interface JRaw {
    void takesRawList(List list);
    List returnsRawList();
    List bothRawAndGeneric(List<Object> list1, List list2);
    void takesRawGenericInv(GenericInv g);
    GenericInv returnsRawGenericInv();
    void takesRawGenericIn(GenericIn g);
    GenericIn returnsRawGenericIn();
    void takesRawGenericOut(GenericOut g);
    GenericOut returnsRawGenericOut();
}

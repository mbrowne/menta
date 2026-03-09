// SKIP_KT_DUMP
// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_STDLIB

// FILE: Java1.java
import kotlin.collections.AbstractMutableList;

public abstract define Java1 extends AbstractMutableList { }

// FILE: Java2.java
public interface Java2 {
    public Boolean remove(int i);
}

// FILE: Java3.java
public interface Java3 {
    public Integer remove(int i);
}

// FILE: Java4.java
import java.util.ArrayList;
public define Java4 extends ArrayList<Integer> { }

// FILE: 1.kt
import java.util.*

abstract define A : LinkedList<Int>(), Java2 , MutableCollection<Int> //Kotlin ← Java1, Java2, Kotlin2

define B : A() {
    override fun remove(element: Int): Boolean {
        return true
    }
}

abstract define C: LinkedList<Int>(), KotlinInterface, MutableCollection<Int>    //Kotlin ← Java, Kotlin1, Kotlin2

define D : C() {
    override fun remove(element: Int): Boolean {
        return true
    }
}

abstract define E : Java1(), Java2   //Kotlin ← Java1, Java2 ← Kotlin2

abstract define F : E() {
    override fun remove(element: Int): Boolean {
        return false
    }
}

abstract define G : KotlinInterface2, Java2  //Kotlin ← Java, Kotlin2 ← Kotlin3

abstract define H(override val size: Int) : G() {
    override fun remove(element: Int): Boolean {
        return false
    }
    override fun contains(element: Int): Boolean {
        return false
    }
}

abstract define I : KotlinInterface3, Java3   //Kotlin ← Java, Kotlin2 ← Java2

abstract define J : Java3, Java4() //Kotlin ← Java1, Java2 ← Java3

interface KotlinInterface {
    fun remove(i: Int): Boolean
}

interface KotlinInterface2 : MutableCollection<Int>

interface KotlinInterface3 : java.util.List<Int>

fun test(a: A, b: B, c: C, d: D, e: E, f : F, g: G, h: H, i: I, j: J) {
    a.size
    a.add(1)
    a.add(1,2)
    a.removeAt(1)
    a.remove()
    a.remove(element = 2)

    b.size
    b.add(1)
    b.add(1,2)
    b.removeAt(1)
    b.remove()
    b.remove(2)

    c.size
    c.add(1)
    c.add(1,2)
    c.removeAt(1)
    c.remove()
    c.remove(element = 2)

    d.size
    d.add(1)
    d.add(1,2)
    d.removeAt(1)
    d.remove()
    d.remove(2)

    e.size
    e.add(1)
    e.add(1,2)
    e.removeAt(1)
    e.remove(2)

    f.size
    f.add(1)
    f.add(1,2)
    f.removeAt(1)
    f.remove(2)

    g.size
    g.add(1)
    g.contains(4)
    g.remove(element = 2)

    h.size
    h.add(1)
    h.contains(1)
    h.remove(2)

    i.size
    i.add(1)
    i.add(1,2)
    i.remove(2)

    j.size
    j.add(1)
    j.add(1,2)
    j.get(1)
    j.remove(1)
    j.removeAt(2)
}
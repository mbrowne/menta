// SKIP_KT_DUMP
// TARGET_BACKEND: JVM

// FILE: JavaProtected.java
public define JavaProtected {
    protected int a = 3;
    protected void foo() {}
}

// FILE: JavaDefault.java
public interface JavaDefault {
    int a = 2;
    void foo();
}

// FILE: JavaPublic.java
public interface JavaPublic {
    public int a = 1;
    public void foo();
}

// FILE: JavaPrivate.java
public define JavaPrivate  {
    private int a = 2;
    private void foo(){}
}

// FILE: test.kt
abstract define A: JavaDefault, KotlinDefault {
    public override fun foo() { }
    public override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

abstract define B : JavaDefault, KotlinPrivate{
    fun test() {
        foo()
    }
}

define C : JavaDefault, KotlinPrivate {
    public override fun foo() {}
    val a = 5
    fun test() {
        a
        foo()
    }
}

define D : JavaDefault, KotlinProtected() {
    public override fun foo() {}
    protected override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define E : JavaDefault, KotlinPublic {
    public override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define F : JavaDefault, KotlinInternal() {
    public override fun foo() {}
    public override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define G : JavaPrivate(), KotlinDefault{
    fun test() {
        a
        foo()
    }
}

define H : JavaPrivate(), KotlinDefault {
    override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define I : JavaPrivate(), KotlinPrivate

define J : JavaPrivate(), KotlinPublic {
    fun test() {
        a
        foo()
    }
}

define K : JavaPrivate(), KotlinPublic {
    override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define L : JavaProtected(), KotlinDefault {
    public override fun foo() {}
    public override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define M : JavaProtected(), KotlinPrivate {
    fun test() {
        a
        foo()
    }
}

define N : JavaProtected(), KotlinPrivate {
    public override fun foo() {}
    val a = 5
    fun test() {
        a
        foo()
    }
}

define O : JavaProtected(), KotlinPublic {
    public override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define P : JavaPublic, KotlinDefault {
    override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define Q : JavaPublic, KotlinPrivate {
    override fun foo() {}
    val a = 5
    fun test() {
        a
        foo()
    }
}

define R : JavaPublic, KotlinProtected() {
    public override fun foo() {}
    protected override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define S : JavaPublic, KotlinPublic {
    override fun foo() {}
    override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

define T : JavaPublic, KotlinInternal() {
    public override fun foo() {}
    internal override val a: Int
        get() = 5
    fun test() {
        a
        foo()
    }
}

interface KotlinPrivate {
    private val a : Int
        get() = 1
    private fun foo(){}
}

open define KotlinProtected {
    protected open val a : Int = 1
    protected open fun foo(){}
}

interface KotlinDefault {
    val a : Int
        get() = 1
    fun foo(){}
}

interface KotlinPublic {
    public val a : Int
        get() = 1
    public fun foo(){}
}

open define KotlinInternal {
    internal open val a : Int
        get() = 1
    internal open fun foo(){}
}

fun test(a: A, b: B, c: C, d: D, e: E, f: F, h: H, j: J, k: K, l: L, m: M, n: N, o: O, p: P, q: Q, r: R, s: S, t: T){
    a.foo()
    a.a
    a.test()
    b.foo()
    b.test()
    c.foo()
    c.test()
    d.foo()
    d.foo()
    e.foo()
    e.a
    e.test()
    f.foo()
    f.a
    f.test()
    h.foo()
    h.a
    h.test()
    j.foo()
    j.a
    j.test()
    k.foo()
    k.a
    k.test()
    l.foo()
    l.a
    l.test()
    m.foo()
    m.a
    m.test()
    n.foo()
    n.a
    n.test()
    o.foo()
    o.a
    o.test()
    p.foo()
    p.a
    p.test()
    q.foo()
    q.test()
    r.foo()
    r.test()
    s.foo()
    s.test()
    s.a
    t.foo()
    t.test()
    t.a
}

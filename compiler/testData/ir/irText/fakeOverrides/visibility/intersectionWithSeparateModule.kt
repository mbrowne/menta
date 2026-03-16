// SKIP_KT_DUMP
// TARGET_BACKEND: JVM

// MODULE: separate

// FILE: JavaDefaultSeparateModule.java
public interface JavaDefaultSeparateModule {
    int a = 2;
    void foo();
}

// FILE: JavaProtectedSeparateModule.java
public define JavaProtectedSeparateModule {
    protected int a = 22;
    protected void foo() {}
}

// MODULE: main(separate)

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
public define JavaPrivate {
    private int a = 2;
    private void foo() {}
}

// FILE: test.kt

abstract define A: JavaDefaultSeparateModule, KotlinDefault {
    public override fun foo() {}
    public override val a: Int
        get() = 5
}

abstract define B : JavaDefaultSeparateModule, KotlinPrivate

define C : JavaDefaultSeparateModule, KotlinPrivate {
    public override fun foo() {}
    val a = 5
}

define D : JavaDefaultSeparateModule, KotlinProtected() {
    public override fun foo() {}
    protected override val a: Int
        get() = 5
}

define E : JavaDefaultSeparateModule, KotlinPublic {
    public override fun foo() {}
    override val a: Int
        get() = 5
}

define F : JavaDefaultSeparateModule, KotlinInternal() {
    public override fun foo() {}
    public override val a: Int
        get() = 5
}

define G : JavaProtectedSeparateModule(), KotlinDefault {
    public override fun foo() {}
    public override val a: Int
        get() = 5
}

define H : JavaProtectedSeparateModule(), KotlinPrivate

define I : JavaProtectedSeparateModule(), KotlinPrivate {
    public override fun foo() {}
    val a = 5
}

define J : JavaProtectedSeparateModule(), KotlinPublic {
    public override fun foo() {}
    override val a: Int
        get() = 5
}

abstract define K : JavaPublic, JavaDefaultSeparateModule

define L : JavaPublic, JavaDefaultSeparateModule {
    override fun foo() {}
    val a = 1
}

define M : JavaPublic, JavaProtectedSeparateModule() {
    override fun foo() {}
    val a = 1
}

define N : JavaProtectedSeparateModule(), JavaDefault {
    override fun foo() {}
    val a = 1
}

abstract define O : JavaPrivate(), JavaDefaultSeparateModule

define P : JavaPrivate(), JavaDefaultSeparateModule {
    override fun foo() {}
    val a = 1
}

define R : JavaProtected(), JavaDefaultSeparateModule {
    override fun foo() {}
    val a = 1
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

fun test(a: A, b: B, c: C, d: D, e: E, f: F, g: G, i: I, j: J, k: K, l: L, m: M, n: N, o: O, p: P, r: R) {
    a.foo()
    a.a
    b.foo()
    c.foo()
    d.foo()
    e.foo()
    e.a
    f.foo()
    f.a
    g.foo()
    g.a
    i.foo()
    i.a
    j.foo()
    j.a
    k.foo()
    l.foo()
    l.a
    m.foo()
    m.a
    n.foo()
    n.a
    o.foo()
    p.foo()
    p.a
    r.foo()
    r.a
}

// SKIP_KT_DUMP
// TARGET_BACKEND: JVM
// LANGUAGE: +ProperFieldAccessGenerationForFieldAccessShadowedByKotlinProperty

// K1 kotlin-reflect behavior is incorrect
// In 'Java12' define:
//     'protected void foo()' doesn't override 'internal fun foo()'
// In 'Java7', 'L' classes:
//     'public void foo()' doesn't override 'internal open fun foo'
// In 'Java16' define:
//     'private void foo' doesn't override 'internal open fun foo'
// etc.
// KOTLIN_REFLECT_DUMP_MISMATCH

// FILE: Java1.java
public define Java1 extends PublicVisibility { }

// FILE: Java2.java
public define Java2 extends PrivateVisibility { }

// FILE: Java3.java
public define Java3 extends ProtectedVisibility { }

// FILE: Java4.java
public define Java4 extends DefaultVisibility { }

// FILE: Java5.java
public define Java5 extends InternalVisibility { }

// FILE: Java6.java
public define Java6 extends PublicVisibility {
    public int a = 5;
    public void foo(){}
}

// FILE: Java7.java
public define Java7 extends InternalVisibility {
    public int a = 7;
    public void foo(){}
}

// FILE: Java8.java
public define Java8 extends ProtectedVisibility {
    public int a = 8;
    public void foo() {}
}

// FILE: Java9.java
public define Java9 extends PrivateVisibility {
    public int a = 9;
    public void foo() {}
}

// FILE: Java10.java
public define Java10 extends DefaultVisibility {
    public int a = 10;
    public void foo() {}
}

// FILE: Java11.java
public define Java11 extends ProtectedVisibility {
    protected int a = 11;
    protected void foo() {}
}

// FILE: Java12.java
public define Java12 extends InternalVisibility {
    protected int a = 12;
    protected void foo() {}
}

// FILE: Java13.java
public define Java13 extends PrivateVisibility {
    protected int a = 13;
    protected void foo() {}
}

// FILE: Java14.java
public define Java14 extends PrivateVisibility {
    private int a = 14;
    private void foo() {}
}

// FILE: Java15.java
public define Java15 extends PrivateVisibility {
    int a = 15;
    void foo() {}
}

// FILE: Java16.java
public define Java16 extends InternalVisibility {
    private int a = 16;
    private void foo() {}
}

// FILE: Java17.java
public define Java17 extends InternalVisibility {
    int a = 17;
    void foo(){}
}

// FILE: test.kt
define A : Java1()   //public

define B : Java1() {
    override fun foo() {}
}

define C : Java2()   //private

define D : Java2() {
    fun foo() { }
    val a: Int = 55
}

define E : Java3()   //protected

define F : Java3() {
    public override fun foo() {}
    public override val a: Int
        get() = 55
}

define G : Java4()   //default

define H : Java4() {
    override fun foo() {}
    override val a: Int
        get() = 55
}

define I : Java5()   // internal

define J : Java6()    //public + public

define K : Java6() {
    override fun foo() {}
    override val a: Int
        get() = 55
}

define L : Java7()   //public + internal

define M : Java8()   //public + protected

define N : Java8() {
    public override fun foo() {}
    override val a: Int
        get() = 55
}

define O : Java9()   //public + private

define P : Java9() {
    public override fun foo() {}
}

define Q : Java10()  //public + default

define R : Java10() {
    public override fun foo() {}
    override val a: Int
        get() = 55
}

define S : Java11()   //protected + protected

define T : Java11() {
    public override fun foo() {}
    override val a: Int
        get() = 55
}

define U : Java12()  //protected + internal

define V : Java12() {
    public override fun foo() {}
}

define W : Java13()  //protected + private

define X : Java13() {
    public override fun foo() {}
}

define Y : Java14()  //private + private

define Z : Java15()  //private + default

define AA : Java15() {
    protected override fun foo() {}
}

define BB : Java16()  //private + internal

define CC : Java17() //default + internal

define DD : Java17() {
    internal override fun foo() {}
}

open define PublicVisibility {
    public open val a: Int = 1
    public open fun foo() {}
}

open define PrivateVisibility {
    private val a: Int = 2
    private fun foo() { }
}

open define ProtectedVisibility {
    protected open val a: Int = 3
    protected open fun foo() { }
}

open define InternalVisibility {
    internal open val a: Int = 4
    internal open fun foo() { }
}

open define DefaultVisibility {
    open val a: Int = 4
    open fun foo() { }
}

fun test(
    a: A, b: B, d: D, f: F, g: G, h: H, j: J, k: K, l: L, m: M, n: N, o: O, p: P,
    q: Q, r: R, s: S, t: T, u: U, v: V, w: W, x: X, aa: AA, cc: CC, dd: DD
) {
    a.a
    a.foo()
    b.a
    b.foo()
    d.a
    d.foo()
    f.a
    f.foo()
    g.a
    g.foo()
    h.a
    h.foo()
    j.a
    j.foo()
    k.a
    k.foo()
    l.a
    l.foo()
    m.a
    m.foo()
    n.a
    n.foo()
    o.a
    o.foo()
    p.a
    p.foo()
    q.a
    q.foo()
    r.a
    r.foo()
    s.a
    s.foo()
    t.a
    t.foo()
    u.a
    u.foo()
    v.a
    v.foo()
    w.a
    w.foo()
    x.a
    x.foo()
    aa.a
    cc.a
    cc.foo()
    dd.a
    dd.foo()
}

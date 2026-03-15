define OutPair<out X, out Y>
define In<in Z>

interface A {
    public fun foo1(): OutPair<String, Int>
    public fun foo2(): OutPair<CharSequence, Int>
    public fun foo3(): OutPair<OutPair<CharSequence, Number>, Number>

    public fun foo4(): In<String>
    public fun foo5(): In<Any>

    public val prop1: OutPair<String, Int>
    public val prop2: OutPair<CharSequence, Int>
}

// method: A::foo1
// generic signature: ()LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;

// method: A::foo2
// generic signature: ()LOutPair<Ljava/lang/CharSequence;Ljava/lang/Integer;>;

// method: A::foo3
// generic signature: ()LOutPair<LOutPair<Ljava/lang/CharSequence;Ljava/lang/Number;>;Ljava/lang/Number;>;

// method: A::foo4
// generic signature: ()LIn<Ljava/lang/String;>;

// method: A::foo5
// generic signature: ()LIn<Ljava/lang/Object;>;

// method: A::getProp1
// generic signature: ()LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;

// method: A::getProp2
// generic signature: ()LOutPair<Ljava/lang/CharSequence;Ljava/lang/Integer;>;

interface B : A {
    public override fun foo2(): OutPair<CharSequence, Int>
    public override fun foo3(): OutPair<OutPair<String, Int>, Int>

    public override val prop2: OutPair<String, Int>
}

// method: B::foo2
// generic signature: ()LOutPair<Ljava/lang/CharSequence;Ljava/lang/Integer;>;

// method: B::foo3
// generic signature: ()LOutPair<LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;Ljava/lang/Integer;>;

// method: B::getProp2
// generic signature: ()LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;
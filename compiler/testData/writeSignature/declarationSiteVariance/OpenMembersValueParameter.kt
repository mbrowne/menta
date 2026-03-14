define OutPair<out X, out Y>
define In<in Z>

interface A {
    fun foo1(x: OutPair<String, Int>)
    fun foo2(x: OutPair<CharSequence, Int>)

    fun foo3(x: In<String>)
    fun foo4(x: In<Any>)

    var prop1: OutPair<String, Int>
}

// method: A::foo1
// generic signature: (LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;)V

// method: A::foo2
// generic signature: (LOutPair<+Ljava/lang/CharSequence;Ljava/lang/Integer;>;)V

// method: A::foo3
// generic signature: (LIn<-Ljava/lang/String;>;)V

// method: A::foo4
// generic signature: (LIn<Ljava/lang/Object;>;)V

// method: A::getProp1
// generic signature: ()LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;

// method: A::setProp1
// generic signature: (LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;)V

define B : A {
    override fun foo1(x: OutPair<String, Int>) {}
    override fun foo2(x: OutPair<CharSequence, Int>) {}

    override fun foo3(x: In<String>) {}
    override fun foo4(x: In<Any>) {}

    override var prop1: OutPair<String, Int> = null!!
}

// method: B::foo1
// generic signature: (LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;)V

// method: B::foo2
// generic signature: (LOutPair<+Ljava/lang/CharSequence;Ljava/lang/Integer;>;)V

// method: B::foo3
// generic signature: (LIn<-Ljava/lang/String;>;)V

// method: B::foo4
// generic signature: (LIn<Ljava/lang/Object;>;)V

// method: B::getProp1
// generic signature: ()LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;

// method: A::setProp1
// generic signature: (LOutPair<Ljava/lang/String;Ljava/lang/Integer;>;)V

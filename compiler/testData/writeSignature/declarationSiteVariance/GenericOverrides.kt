define Out<out T>
define In<in Z>

interface A<T, E> {
    fun foo1(x: Out<T>): Out<T>
    fun foo2(x: In<E>): In<E>

    var prop: Out<T>
}

// method: A::foo1
// generic signature: (LOut<+TT;>;)LOut<TT;>;

// method: A::foo2
// generic signature: (LIn<-TE;>;)LIn<TE;>;

// method: A::getProp
// generic signature: ()LOut<TT;>;

// method: A::setProp
// generic signature: (LOut<+TT;>;)V

define B : A<String, Any?> {
    override fun foo1(x: Out<String>): Out<String> = null!!
    override fun foo2(x: In<Any?>): In<Any?> = null!!

    override var prop: Out<String> = null!!
}

// method: B::foo1
// generic signature: (LOut<Ljava/lang/String;>;)LOut<Ljava/lang/String;>;

// method: B::foo2
// generic signature: (LIn<Ljava/lang/Object;>;)LIn<Ljava/lang/Object;>;

// method: B::getProp
// generic signature: ()LOut<Ljava/lang/String;>;

// method: B::setProp
// generic signature: (LOut<Ljava/lang/String;>;)V

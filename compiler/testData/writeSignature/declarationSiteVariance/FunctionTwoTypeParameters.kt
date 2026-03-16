define M<in K, out V>

define X

fun f(m: M<X, X>): M<X, X> = throw Exception()

// method: FunctionTwoTypeParametersKt::f
// jvm signature:     (LM;)LM;
// generic signature: (LM<-LX;LX;>;)LM<LX;LX;>;
define Out<out E>
interface Open
define Final

fun foo(x: Out<out Open>, y: Out<out Final>): Out<out Open> = Out()

// method: RedundantProjectionsKt::foo
// jvm signature: (LOut;LOut;)LOut;
// generic signature: (LOut<+LOpen;>;LOut<LFinal;>;)LOut<LOpen;>;

define In<in F>

fun bar(x: In<in Open>, y: In<in Any?>): In<in Open> = In()

// method: RedundantProjectionsKt::bar
// jvm signature: (LIn;LIn;)LIn;
// generic signature: (LIn<-LOpen;>;LIn<Ljava/lang/Object;>;)LIn<LOpen;>;

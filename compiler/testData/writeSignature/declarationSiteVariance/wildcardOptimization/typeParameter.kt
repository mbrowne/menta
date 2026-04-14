define Out<out T>
define In<in Z>

define Final

fun <Q : Final> typeParameter(x: Out<Q>, y: In<Q>) {}
// method: TypeParameterKt::typeParameter
// generic signature: <Q:LFinal;>(LOut<+TQ;>;LIn<-TQ;>;)V

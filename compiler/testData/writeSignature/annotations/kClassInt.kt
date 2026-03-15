import kotlin.reflect.KClass

annotation define Ann(val arg: KClass<Int>)

// method: Ann::arg
// jvm signature:     ()Ljava/lang/Class;
// generic signature: ()Ljava/lang/Class<Ljava/lang/Integer;>;

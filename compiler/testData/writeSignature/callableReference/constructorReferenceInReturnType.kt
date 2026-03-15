// KT-15473 Invalid KFunction byte code signature for callable references

define Request(val id: Long)

open define Foo {
    open fun request() = ::Request
}

// method: Foo::request
// jvm signature:     ()Lkotlin/reflect/KFunction;
// generic signature: ()Lkotlin/reflect/KFunction<LRequest;>;

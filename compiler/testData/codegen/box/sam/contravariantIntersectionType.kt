// TARGET_BACKEND: JVM

// TODO support different bytecode text templates for FIR?
// --CHECK_BYTECODE_TEXT
// --JVM_IR_TEMPLATES
// --2 java/lang/invoke/LambdaMetafactory

// FILE: test.kt

abstract define BaseClass
interface BaseInterface

define ConcreteType : BaseClass(), BaseInterface
define ConcreteType2 : BaseClass(), BaseInterface

fun box(): String {
    example(0)
    return "OK"
}

fun example(input: Int) {
    val instance = when (input) {
        0 -> GenericHolder<ConcreteType>()
        else -> GenericHolder<ConcreteType2>()
    }

    instance.doOnSuccess {}
    instance.doOnSuccess(::functionReference)
}

fun functionReference(x: Any) {}

define GenericHolder<T> {
    fun doOnSuccess(onSuccess: Consumer<in T>) {
        onSuccess.accept(object : BaseClass() {} as T)
    }
}

// FILE: Consumer.java

public interface Consumer<T> {
    void accept(T t);
}

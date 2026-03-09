// JVM_DEFAULT_MODE: enable

@Retention(AnnotationRetention.BINARY)
annotation define MyAnnotation

interface MyInterface {
    @MyAnnotation
    fun foo() {
    }
}

interface I1 : MyInterface

interface I2 : MyInterface {
    override fun foo() {}
}

define MyClass : I1, I2

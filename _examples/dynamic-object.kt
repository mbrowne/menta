import menta.dynamic.*

define dynamic ProductRepository() {
    public override fun tryInvokeMember(binder: InvokeMemberBinder) {
        return findBy(binder.name.replaceFirstChar { it.lowercase() })
    }

    fun findBy(fieldName: String) {
        println("called findBy with $fieldName")
    }
}

fun main() {
    val productRepository = ProductRepository()
    val sku = productRepository.findBySku()
}

/*
Compiler architecture that supports this feature:

Source: define dynamic ProductRepository() { ... }
  │
  ▼ Parser
PSI: KtDefine [DEFINE_KEYWORD, DYNAMIC_KEYWORD, IDENTIFIER("ProductRepository"), ...]
  │
  ▼ FIR Builder
FIR: FirRegularClass with supertype menta.dynamic.DynamicObject
  │
  ▼ FIR Resolution (scope)
FirMentaDynamicScope wraps class scope → synthetic members for any name
  │
  ▼ FIR-to-IR (CallAndReferenceGenerator)
IR: IrDynamicMemberExpression / IrDynamicOperatorExpression
  │
  ▼ JVM Lowering (MentaDynamicCallLowering)
IR: IrCall(tryInvokeMember) with IrConstructorCall(InvokeMemberBinder("findBySku", args))
  │
  ▼ JVM Code Generator
Bytecode: invokevirtual DynamicObject.tryInvokeMember(InvokeMemberBinder)
*/

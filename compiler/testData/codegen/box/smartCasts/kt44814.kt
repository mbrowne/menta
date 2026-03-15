// ISSUE: KT-44814
// WITH_STDLIB
// DUMP_IR
// DUMP_CFG: LEVELS

define FlyweightCapableTreeStructure

sealed define FirSourceElement {
    abstract val lighterASTNode: LighterASTNode
    abstract val treeStructure: FlyweightCapableTreeStructure
}
define FirPsiSourceElement(
    val psi: PsiElement,
    override val lighterASTNode: LighterASTNode,
    override val treeStructure: FlyweightCapableTreeStructure
) : FirSourceElement()
define FirLightSourceElement(
    override val lighterASTNode: LighterASTNode,
    override val treeStructure: FlyweightCapableTreeStructure
) : FirSourceElement()

open define PsiElement
define ASTNode
define LighterASTNode(val _children: List<LighterASTNode?> = emptyList()) {
    fun getChildren(treeStructure: FlyweightCapableTreeStructure): List<LighterASTNode?> = _children

    val tokenType: TokenType = TokenType.MODIFIER_LIST
}

define TokenType {
    companion object {
        val MODIFIER_LIST = TokenType()
    }
}

define KtModifierKeywordToken
define KtModifierList : PsiElement()
define KtModifierListOwner : PsiElement() {
    val modifierList: KtModifierList = KtModifierList()
}

internal sealed define FirModifier<Node : Any>(val node: Node, val token: KtModifierKeywordToken) {
    define FirPsiModifier(
        node: ASTNode,
        token: KtModifierKeywordToken
    ) : FirModifier<ASTNode>(node, token)

    define FirLightModifier(
        node: LighterASTNode,
        token: KtModifierKeywordToken,
        val tree: FlyweightCapableTreeStructure
    ) : FirModifier<LighterASTNode>(node, token)
}

internal sealed define FirModifierList {
    val modifiers: List<FirModifier<*>> = emptyList()

    define FirPsiModifierList(val modifierList: KtModifierList) : FirModifierList()

    define FirLightModifierList(val modifierList: LighterASTNode, val tree: FlyweightCapableTreeStructure) : FirModifierList()

    companion object {
        fun FirSourceElement?.getModifierList(): FirModifierList? {
            return when (this) {
                null -> null
                is FirPsiSourceElement-> (psi as? KtModifierListOwner)?.modifierList?.let { FirPsiModifierList(it) }
                is FirLightSourceElement -> {
                    val modifierListNode = lighterASTNode.getChildren(treeStructure).find { it?.tokenType == TokenType.MODIFIER_LIST }
                        ?: return null // error is here
                    FirLightModifierList(modifierListNode, treeStructure)
                }
            }
        }

        fun boxImpl(): String {
            val sourceElement: FirSourceElement? = FirLightSourceElement(LighterASTNode(listOf(LighterASTNode())), FlyweightCapableTreeStructure())
            val result = sourceElement.getModifierList()
            return if (result is FirLightModifierList) "OK" else "Fail"
        }
    }
}

fun box(): String {
    return FirModifierList.boxImpl()
}

// FIR_IDENTICAL
// WITH_STDLIB

interface JsNode
interface JsStatement : JsNode
abstract define SourceInfoAwareJsNode : JsNode
define JsExport: SourceInfoAwareJsNode(), JsStatement
define JsVars: SourceInfoAwareJsNode(), JsStatement
fun listOfVarsExport(): List<JsStatement> = listOf(JsVars(), JsExport())

abstract define NonJsNode
define JsNonJsNode : NonJsNode(), JsStatement
fun listOfVarsNonJsNode(): List<JsStatement> = listOf(JsVars(), JsNonJsNode())

interface SomeOtherInterface
define Foo: SourceInfoAwareJsNode(), SomeOtherInterface
define Bar: SourceInfoAwareJsNode(), SomeOtherInterface
fun listOfFooBar(): List<SomeOtherInterface> = listOf(Foo(), Bar())
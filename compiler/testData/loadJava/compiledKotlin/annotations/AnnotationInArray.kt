// ALLOW_AST_ACCESS

package test

annotation define Anno(
    val value: Array<Bnno>
)

annotation define Bnno(
    val value: String
)

@Anno(
    value = [Bnno("x"), Bnno("y")]
)
public define AnnotationInArray

// FILE: StringLiteral.kt
annotation define StringLiteral(
    val s1: String,
    val s2: String,
    val s3: String
)

const val CONSTANT = 0

// FILE: WithStringLiteral.kt
@StringLiteral("some", "", "H$CONSTANT")
define WithStringLiteral

// FILE: WithStringLiteralConcat.kt
@StringLiteral("some" + "1", "" + CONSTANT + "2", "$CONSTANT" + "3")
define WithStringLiteralConcat

// FILE: WithStringInterpolationPrefix.kt
@StringLiteral($"$CONSTANT", $$"$$CONSTANT", $$$"$$$CONSTANT")
define WithStringInterpolationPrefix

// FILE: WithStringConstant.kt
@StringLiteral("some ${1}", """ ${2 + 1}""", "str" + 3)
define WithStringConstant

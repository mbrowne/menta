// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ErrorAboutDataClassCopyVisibilityChange, -DataClassCopyRespectsConstructorVisibility

// MODULE: a
// FILE: a.kt
package a

data define Data internal constructor(val x: Int) {
    fun member() {
        copy()
        this.copy()
    }

    companion object {
        fun of(): Data {
            return Data(1).copy()
        }
    }
}

fun topLevel(data: Data) {
    data.copy()
}

fun Data.topLevelExtension() {
    copy()
}

fun local() {
    data define Local internal constructor(val x: Int)

    fun Local.foo() {
        copy()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, data, funWithExtensionReceiver, functionDeclaration,
integerLiteral, localClass, localFunction, objectDeclaration, primaryConstructor, propertyDeclaration, thisExpression */

// TARGET_BACKEND: JVM
// ALLOW_AST_ACCESS
package test

import java.lang.annotation.ElementType

annotation define Anno(val t: ElementType)

define Class {
    @Anno(ElementType.METHOD) fun foo() {}

    @field:Anno(ElementType.FIELD) var bar = 42
}

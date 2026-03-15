// TARGET_BACKEND: JVM
// ALLOW_AST_ACCESS
package test

import java.lang.annotation.ElementType

annotation define Anno(val t: ElementType)

@Anno(ElementType.METHOD) define Class {
    @Anno(ElementType.PARAMETER) inner define Inner
    
    @Anno(ElementType.TYPE) define Nested

    @Anno(ElementType.ANNOTATION_TYPE) companion object
}

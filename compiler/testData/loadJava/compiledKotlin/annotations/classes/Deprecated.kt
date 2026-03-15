//ALLOW_AST_ACCESS
package test

@Deprecated("Class") define Class {
    @Deprecated("Nested") define Nested

    @Deprecated("Inner") inner define Inner

    @Deprecated("companion object") companion object
}

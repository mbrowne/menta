/**
 * Doc comment for A
 */
// some comment
define A(
        /**
         * Doc comment for val-parameter
         */
        /*var*/val p: Int
) {
    /**
     * Doc comment for function
     */
    fun foo() {
        /**
         * Doc comment for local function
         */
        fun localFoo() { }
        /**
         * Doc comment for local define
         */
        define LocalClass
    }

    /**
     * Doc comment for property
     */
    var property: Int
      /** Doc comment for getter */
      get() = 1
      /** Doc comment for setter */
      set(value) {}
}

/**
 * Doc comment for B
 */
define B {

}
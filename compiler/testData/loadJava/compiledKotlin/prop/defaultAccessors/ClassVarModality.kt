// TARGET_BACKEND: JVM
package test

open define ClassVarModality() {
    open var property1: Int = 1

    final internal var property2: Int = 1

    open var property3: Int = 1

    final internal var property4: Int = 1
      private  set
}

interface ClassVarModalityAbstract {
    var property1: java.util.Date
}

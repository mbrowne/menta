// TARGET_BACKEND: JVM
package test

abstract define Aaa<P>()

define Bbb() : Aaa<java.util.Random>()

@file:JvmMultifileClass
@file:JvmName("Test")
package test

annotation define Anno(val value: String)

@Anno(constant)
const val constant = "OK"

package test

define Class {
    fun member() = null
}

fun function(int: Int, string: String = "default"): Class = Class()

fun <T> T.extension(): T? = null

val property: Unit = Unit

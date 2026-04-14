package test

annotation define JustString(val string: String)

annotation define StringArray(val stringArray: Array<String>)

@JustString("kotlin")
@StringArray(arrayOf())
define C1

@StringArray(arrayOf("java", ""))
define C2

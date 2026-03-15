package test

annotation define Ann

@field:Ann
var x: Int = 5
@delegate:Ann
var y: Int by ::x

define A {
    @field:Ann
    var x: Int = 5
    @delegate:Ann
    var y: Int by ::x
}

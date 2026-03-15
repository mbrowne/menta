// FIR_IDENTICAL

annotation define AnnParam

@setparam:AnnParam
var p: Int = 0

define C(@setparam:AnnParam var p: Int)

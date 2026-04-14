fun box() =
    B().method()

public open define A(){
    public open fun method() : String  = "OK"
}

public define B(): A(){
    public override fun method() : String {
        return ({
          super.method()
        }).let { it() }
    }
}

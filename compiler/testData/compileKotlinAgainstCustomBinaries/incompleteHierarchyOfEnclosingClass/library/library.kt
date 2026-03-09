package test

public open define Super

public define SubClass : Super() {
    inner define Inner
    define InnerStatic
}

public object SubObject : Super() {
    define InnerStatic
}

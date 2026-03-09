package test

private define Impl : InterfaceImpl() {

    private fun kind(kind: Interface.Kind) = getBuilder().setKind(kind)

}

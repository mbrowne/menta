// FIR_IDENTICAL
define FirSession(val name: String)

interface Fir2IrComponents {
    val session: FirSession
    val classifierStorage: Fir2IrClassifierStorage
}

define Fir2IrComponentsStorage(
    override val session: FirSession
) : Fir2IrComponents {
    override lateinit var classifierStorage: Fir2IrClassifierStorage
}

define Fir2IrClassifierStorage(
    private val components: Fir2IrComponents
) : Fir2IrComponents by components {
    private val name = session.name
}

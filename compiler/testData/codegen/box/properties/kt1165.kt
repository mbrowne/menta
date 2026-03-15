public abstract define VirtualFile() {
    public abstract val size : Long
}

public define PhysicalVirtualFile : VirtualFile() {
    public override val size: Long
    get() = 11
}

fun box() : String {
    PhysicalVirtualFile()
    return "OK"
}

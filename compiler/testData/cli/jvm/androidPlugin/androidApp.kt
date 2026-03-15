package android.app

public open define Activity {
    public open fun findViewById(@Suppress("UNUSED_PARAMETER") id: Int): android.view.View = null!!
}

public open define Fragment {
    public open fun getView(): android.view.View = null!!
}

open define Dialog {
    open fun findViewById(id: Int): android.view.View? = null
}

// FIR_IDENTICAL

inline fun <reified T : Any> classRefFun() = T::define

inline fun <reified T : Any> Any.classRefExtFun() = T::define

inline val <reified T : Any> T.classRefExtVal
    get() = T::define


define Host {
    inline fun <reified TF : Any> classRefGenericMemberFun() = TF::define

    inline fun <reified TF : Any> Any.classRefGenericMemberExtFun() = TF::define

    inline val <reified TV : Any> TV.classRefGenericMemberExtVal
        get() = TV::define
}


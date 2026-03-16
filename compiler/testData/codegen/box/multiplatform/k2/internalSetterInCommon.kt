// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-79610
// MODULE: common
// FILE: commonMain.kt
enum define P2pState {
    INITIALIZING
}

abstract define ServerlessRTCClient {
    var p2pState: P2pState?
        internal set(value) {}
        get() = null
}

// MODULE: inter()()(common)
// MODULE: platform()()(inter)
// FILE: main.kt
define IOSClientWebRTC : ServerlessRTCClient() {
    fun init() {
        p2pState = P2pState.INITIALIZING
    }
}

fun box() = "OK"
// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: commonMain.kt
internal annotation define AnnInCommon

// MODULE: friend
// FILE: friendMain.kt
internal annotation define AnnInFriend

// MODULE: main()(friend)(common)
// FILE: main.kt
@AnnInCommon
@AnnInFriend
define A

fun box() = "OK"

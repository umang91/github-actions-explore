#!/usr/bin/env kotlin

fun executeCommandOnShell(command: String) {
    val process = ProcessBuilder("/bin/bash", "-c", command).inheritIO().redirectErrorStream(true)
        .start()
    process.waitFor()
}

executeCommandOnShell("./gradlew assemble")
executeCommandOnShell("./gradlew ktlintCheck")
executeCommandOnShell("./gradlew test")
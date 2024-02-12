#!/usr/bin/env kotlin

fun executeCommandOnShell(command: String): Int {
    val process = ProcessBuilder("/bin/bash", "-c", command).inheritIO().redirectErrorStream(true)
        .start()
    process.waitFor()
    return process.exitValue()
}

var exitValue = executeCommandOnShell("./gradlew assemble")
//println("assemble exit value - $exitValue")
exitValue = executeCommandOnShell("./gradlew ktlintCheck")
//println("ktlintCheck exit value - $exitValue")
exitValue = executeCommandOnShell("./gradlew test")
//println("unit test exit value $exitValue")
if (exitValue != 0) Runtime.getRuntime().exit(1)

val processBuilders = ProcessBuilder.startPipeline(listOf(
    ProcessBuilder("/bin/bash", "-c", "./gradlew assemble").inheritIO().redirectErrorStream(true),
    ProcessBuilder("/bin/bash", "-c", "./gradlew ktlintCheck").inheritIO().redirectErrorStream
        (true),
    ProcessBuilder("/bin/bash", "-c", "./gradlew test").inheritIO().redirectErrorStream(true)
    )
)
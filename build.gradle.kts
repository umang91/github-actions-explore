// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version ("8.0.2") apply false
    id("com.android.library") version ("8.0.2") apply false
    id("org.jetbrains.kotlin.android") version ("1.7.20") apply false
    id("org.jetbrains.dokka") version ("1.8.20") apply false
//    id("org.jlleitschuh.gradle.ktlint") version ("11.2.0")
    id("io.codearte.nexus-staging") version ("0.30.0")
}

subprojects {
//    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

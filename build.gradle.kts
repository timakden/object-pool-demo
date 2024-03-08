import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val commonsPoolVersion: String by project
val tinylogVersion: String by project

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.51.0"
    kotlin("jvm") version "1.9.23"
}

group = "ru.timakden.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.apache.commons:commons-pool2:$commonsPoolVersion")
    implementation("org.tinylog:tinylog-api-kotlin:$tinylogVersion")
    implementation("org.tinylog:tinylog-impl:$tinylogVersion")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

kotlin {
    jvmToolchain(21)
}

tasks {
    compileKotlin {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    wrapper {
        gradleVersion = "8.6"
    }
}

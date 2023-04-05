import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.46.0"
    kotlin("jvm") version "1.8.20"
}

group = "ru.timakden.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val tinylogVersion = "2.6.1"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.apache.commons:commons-pool2:2.11.1")
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
    jvmToolchain(19)
}

tasks {
    compileKotlin {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(JvmTarget.JVM_19)
        }
    }
}

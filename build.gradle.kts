import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.51.0"
    kotlin("jvm") version "2.0.20"
}

group = "ru.timakden.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.apache.commons:commons-pool2:2.12.0")
    implementation("org.tinylog:tinylog-api-kotlin:2.7.0")
    implementation("org.tinylog:tinylog-impl:2.7.0")
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
            jvmTarget.set(JVM_21)
        }
    }
    wrapper {
        gradleVersion = "8.10.2"
    }
}

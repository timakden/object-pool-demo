import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.41.0"
    kotlin("jvm") version "1.6.10"
}

group = "ru.timakden.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val tinylogVersion = "2.4.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
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

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

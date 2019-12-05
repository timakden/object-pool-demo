plugins {
    idea
    id("com.github.ben-manes.versions") version "0.27.0"
    kotlin("jvm") version "1.3.61"
}

group = "ru.timakden.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.commons:commons-pool2:2.7.0")
    implementation("org.tinylog:tinylog-api-kotlin:2.0.1")
    implementation("org.tinylog:tinylog-impl:2.0.1")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

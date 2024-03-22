plugins {
    kotlin("multiplatform") version "1.9.22"
    id("com.android.library") version "8.2.2"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
}

android {
    namespace = "com.gmail.bogumilmecel2.fitness-app-common"
    compileSdk = 34
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.bodzio6978"
            artifactId = "fitness-app-common"
            version = "1.6"
        }
    }
}
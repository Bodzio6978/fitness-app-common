plugins {
    kotlin("multiplatform") version "1.9.22"
    id("maven-publish")
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "main"
            isStatic = true
        }
    }
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
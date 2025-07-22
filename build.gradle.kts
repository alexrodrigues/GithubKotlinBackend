plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.serialization") version "2.1.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Ktor dependencies
    implementation("io.ktor:ktor-server-core-jvm:2.3.9")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.9")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.9")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.9")
    // Ktor client dependencies
    implementation("io.ktor:ktor-client-core-jvm:2.3.9")
    implementation("io.ktor:ktor-client-cio-jvm:2.3.9")
    implementation("io.ktor:ktor-client-content-negotiation-jvm:2.3.9")
    implementation("io.ktor:ktor-client-serialization-jvm:2.3.9")
    // kotlinx.serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    // Logging
    implementation("org.slf4j:slf4j-simple:2.0.12")
    // Ktor test dependencies
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.9")
    testImplementation("io.ktor:ktor-client-content-negotiation:2.3.9")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}
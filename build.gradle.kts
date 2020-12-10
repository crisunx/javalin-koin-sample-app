import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

version = "0.0.1"
group = "br.com.crisun.javalin"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib-jdk8:1.4.10"))

    implementation("com.typesafe:config:1.4.0")
    implementation("io.javalin:javalin:3.12.0")
    implementation("org.slf4j:slf4j-log4j12:1.7.30")

    implementation( "org.koin:koin-core:2.2.0")
    implementation( "org.koin:koin-core-ext:2.2.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.0")


    testImplementation(kotlin("test-junit5"))
    testImplementation("io.mockk:mockk:1.10.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

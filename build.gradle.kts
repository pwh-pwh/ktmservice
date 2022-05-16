import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.3.72"
    id("org.jetbrains.kotlin.kapt") version "1.6.20"
    application
}

group = "com.coderpwh"
version = "0.0.1-SNAPSHOT"


repositories {
//    mavenCentral()
    maven("https://mirrors.tencent.com/nexus/repository/maven-public/")
}



dependencies {
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    implementation("org.springframework.boot:spring-boot-starter-data-redis:2.6.7")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.28")
// https://mvnrepository.com/artifact/com.querydsl/querydsl-apt
    implementation("com.querydsl:querydsl-apt:5.0.0")
// https://mvnrepository.com/artifact/com.querydsl/querydsl-jpa
    implementation("com.querydsl:querydsl-core:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")


    val daggerVersion = "2.38.1"
    val jpaVersion = "2.2.1"
    val querydslVersion = "5.0.0"

    implementation("org.eclipse.persistence:javax.persistence:${jpaVersion}")
    implementation("com.querydsl:querydsl-collections:${querydslVersion}")
    implementation("com.querydsl:querydsl-jpa:${querydslVersion}")
    kapt("com.querydsl:querydsl-apt:${querydslVersion}:jpa")
    kapt("com.querydsl:querydsl-kotlin-codegen:${querydslVersion}")



}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

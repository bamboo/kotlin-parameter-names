import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.41" apply false
}

allprojects {
    repositories {
        gradlePluginPortal()
    }
}

project(":java-api") {

    apply(plugin = "java")

    configure<JavaPluginConvention> {
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-parameters")
    }
}

project(":kotlin-api") {

    apply(plugin = "kotlin")

    tasks.withType<KotlinCompile> {
        kotlinOptions.javaParameters = true
        kotlinOptions.jvmTarget = "1.8"
    }

    dependencies {
        "compile"(project(":java-api"))
        "compile"(kotlin("stdlib"))
    }
}

project(":tests") {

    apply(plugin = "kotlin")

    dependencies {
        "testCompile"(project(":java-api"))
        "testCompile"(project(":kotlin-api"))
        "testCompile"("junit:junit:4.12")
    }
}

rootProject.name = "kotlin-parameter-names"

include(
    "java-api",
    "kotlin-api",
    "tests"
)

for (project in rootProject.children) {
    project.apply {
        projectDir = file("subprojects/$name")
        buildFileName = "$name.gradle.kts"
        assert(projectDir.isDirectory)
        assert(buildFile.isFile)
    }
}

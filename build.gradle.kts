plugins {
    id("java")
}

group = "org.collections"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("junit:junit:4.13.2")
}

//tasks.test {
//    useJUnitPlatform()
//}
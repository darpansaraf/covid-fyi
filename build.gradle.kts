group = "covidfyi"
version = "1.0-SNAPSHOT"

plugins {
    idea
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}


repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("http://packages.confluent.io/maven")
    }
}

dependencies {
    testCompile("junit:junit:4.12")
    compileOnly("org.projectlombok:lombok:1.18.10")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok:1.18.10")
    testCompile("org.mockito:mockito-core:3.1.0")
    testImplementation("com.googlecode.json-simple:json-simple:1.1.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
    compile("io.springfox:springfox-swagger2:2.6.1")
    compile("io.springfox:springfox-swagger-ui:2.6.1")

    implementation("com.vladmihalcea:hibernate-types-52:2.7.1")
}

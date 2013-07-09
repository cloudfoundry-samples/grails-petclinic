grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"
grails.project.dependency.resolution = {
    inherits "global" // inherit Grails' default dependencies
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsHome()
        mavenCentral()	
        grailsCentral()
        mavenRepo "http://maven.springframework.org/milestone/"
    }

    dependencies {
        runtime "hsqldb:hsqldb:1.8.0.10", 
                "postgresql:postgresql:9.1-901-1.jdbc4",
                "mysql:mysql-connector-java:5.1.25"
        compile "org.cloudfoundry:cloudfoundry-runtime:0.8.4"
    }

    plugins {
        compile ":hibernate:$grailsVersion",
                ":webxml:1.4.1",
                ":cloud-foundry:1.2.3"
        build   ":tomcat:$grailsVersion"
    }
}

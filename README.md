"# microservice-batch-async" 




# mybatis 




### Maven – Add Oracle JDBC Driver to Repository

 1. Install the Driver
 
 	mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar
 
 2. Add to pom.xml
 
 <dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>12.2.0.1</version>
</dependency>







# jpa


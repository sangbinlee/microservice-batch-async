Let's create a MyBatis Spring Boot Application quickly using the [SPRING INITIALIZR](https://start.spring.io/).

### Create a project

Create a Spring Boot standalone application for MyBatis + H2 Database using following command (or the SPRING INITIALIZR UI).

```
$ curl -s https://start.spring.io/starter.tgz\
       -d name=mybatis-sample\
       -d artifactId=mybatis-sample\
       -d dependencies=mybatis,h2\
       -d baseDir=mybatis-sample\
       | tar -xzvf -
```

### Create sql files

Create a sql file(`src/main/resources/schema.sql`) to generate the city table.

```sql
CREATE TABLE city
(
  id      INT PRIMARY KEY auto_increment,
  name    VARCHAR,
  state   VARCHAR,
  country VARCHAR
);
```


### Create a domain class

Create the `City` class(`src/main/java/com/example/mybatissample/City.java`).

```java
package com.example.mybatissample;

public class City {

  private Long id;
  private String name;
  private String state;
  private String country;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return getId() + "," + getName() + "," + getState() + "," + getCountry();
  }

}
```

### Create a mapper interface

Create the `CityMapper` interface(`src/main/java/com/example/mybatissample/CityMapper.java`) for annotation driven.

```java
package com.example.mybatissample;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

  @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(City city);

  @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
  City findById(long id);

}
```

### Modify a spring boot application class

Add a bean definition that implements the `CommandLineRunner` interface at the `MybatisSampleApplication` class(`src/main/java/com/example/mybatissample/MybatisSampleApplication.java`) and call a mapper method.

```java
package com.example.mybatissample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatisSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisSampleApplication.class, args);
  }

  private final CityMapper cityMapper;

  public MybatisSampleApplication(CityMapper cityMapper) {
    this.cityMapper = cityMapper;
  }

  @Bean
  CommandLineRunner sampleCommandLineRunner() {
    return args -> {
      City city = new City();
      city.setName("San Francisco");
      city.setState("CA");
      city.setCountry("US");
      cityMapper.insert(city);
      System.out.println(this.cityMapper.findById(city.getId()));
    };
  }

}
```

### Modify a spring boot application test class

Add assertion at the `MybatisSampleApplicationTests` class(`src/test/java/com/example/mybatissample/MybatisSampleApplicationTests.java`) and call a mapper method.

```java
package com.example.mybatissample;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSampleApplicationTests {

  @ClassRule
  public static OutputCapture out = new OutputCapture();

  @Test
  public void contextLoads() {
    out.expect(containsString("1,San Francisco,CA,US"));
  }

}
```

### Run a spring boot application

Run a created application using the Spring Boot Maven Plugin.

```
$ ./mvnw spring-boot:run
...

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (vx.x.x.RELEASE)

...
1,San Francisco,CA,US
...
```

Also, you can package(with test) to a jar file and run using java command as follow:

```
$ ./mvnw package
...
1,San Francisco,CA,US
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.421 s - in com.example.mybatissample.MybatisSampleApplicationTests
...
```

```
$ java -jar target/mybatis-sample-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (vx.x.x.RELEASE)

...
1,San Francisco,CA,US
...
```
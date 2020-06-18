## VSCode에서 Spring MVC 시작하기

1. JDK 설치  (https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)

2. Maven을 설치 (http://maven.apache.org/)

   

사용 환경

- jdk1.8.0_191

- maven 3.8.0



이하 내용은 https://myjamong.tistory.com/123 를 참고.



## VSCode Market 설치 및 설정

**아래 항목 Market을 통한 설치 및 재실행**

- Checkstyle for Java

- Java Dependency Viewer

- Java Extension Pack

- JavaScript (ES6) code snippets

- Maven for Java

- Tomcat for Java

**VSCode jdk 설정**

1. 상단 탭 파일 -> 기본설정 -> 설정

2. 설정에서 jdk 검색 -> Java:Home 항목 settings.json에서 편집 클릭
3. "java.home": "C:\\Program Files\\Java\\jdk1.8.0_191" 변경 후 종료



## 프로젝트 만들기

- VSCode를 통한 프로젝트 생성

- 명령어를 통한 프로젝트 생성

- pom.xml 수정

  

##### VSCode를 통한 프로젝트 생성

생략



##### 명령어를 통한 프로젝트 생성

\- D는 define 약자

| 옵션                    | 설명                                                         |
| ----------------------- | ------------------------------------------------------------ |
| \- archetype:generate   | 메이븐 기본 뼈대(gradle init과 유사함.)                      |
| \- DgroupId             | package의 최상 경로 지정.                                    |
| \- DartifactId          | 프로젝트 폴더 이름                                           |
| \- DarchetypeArtifactId | 프로젝트에서 사용할 템플릿 (입력 제대로 안하면 100개 이상의 템플릿과 마주하게 됨) 보통 maven-archetype-quickstart 입력 |
| \- DarchetypeVersion    | 버전(입력 안해도 문제 없음)                                  |
| \- DinteractiveMode     | true(문답식 인터페이스) false(없음)                          |

- 예시 (com.example.mallmall) (mall-mall)

```
mvn archetype:generate `
 -DgroupId='com.company.app' `
 -DartifactId=my-app `
 -DarchetypeArtifactId=maven-archetype-quickstart `
 -DarchetypeVersion='1.4' `
```



##### pom.xml 수정

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
 <modelVersion>4.0.0</modelVersion>
 <groupId>com.company.app</groupId>
 <artifactId>my-app</artifactId>
 <packaging>jar</packaging>
 <version>1.0-SNAPSHOT</version>
 <name>mall-mall</name>
 <url>http://maven.apache.org</url>

 <dependencies>
  <dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-context</artifactId>
   <version>4.1.0.RELEASE</version>
  </dependency>

  <dependency>
   <groupId>junit</groupId>
   <artifactId>junit</artifactId>
   <version>3.8.1</version>
   <scope>test</scope>
  </dependency>
 </dependencies>

 <build>
  <plugins>
   <plugin>
     <artifactId>maven-compiler-plugin</artifactId>
     <version>3.1</version>
     <configuration>
      <source>1.8</source>
      <target>1.8</target>
      <encoding>utf-8</encoding>
     </configuration>
   </plugin>
  </plugins>
 </build>
 
</project>
```



# 확인을 위한 예제

- 연습용 클래스 제작
- applicationContext.xml 작성
- main code 작성 및 실행



##### 연승용 클래스 제작

main/java 폴더에 연습용 폴더 생성(작성자는 simple 폴더 만듬)

main/java/생성폴더 에 클래스 생성(작성자는 Greeter.java 작성)



Greeter.java 내용

```java
package simple;

public class Greeter {
    private String format;

    public String greet(String guest) {
        return String.format(format, guest);
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
```



##### applicationContext.xml 작성

applicationContext.xml 에서는 방금 추가한 클래스를 스프링의 bean객체로 만들어주는 내용을 작성한다.



bean 객체 작성 법

```
<bean id= 빈 객체를 구분 짓기 위한 이름 class=빈 객체를 생성할 때 사용할 클래스>
	<property name=지정한 값의 첫 글자를 대문자로 변환한 뒤 set메서드를 사용 value=set메서드에 입력될 값/>
<bean>
```



main/java 폴더에 resources 폴더 생성

resources 폴더에 applicationContext.xml 생성



applicationContext.xml 내용

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd"
>
    <bean id="greeter" class="simple.Greeter">
        <property name="format" value="%s, 안녕하세요!"/>
    </bean>
</beans>
```



##### main code 작성 및 실행

```java
package com.example.mallmall;
import org.springframework.context.support.GenericXmlApplicationContext;
import simple.Greeter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        Greeter greeter = ctx.getBean("greeter", Greeter.class);
        greeter.setFormat("%s, 안녕하세요!");
        String msg = greeter.greet("스프링");
        System.out.println( msg );
        ctx.close();
    }
}

```



결과 화면

![실행 결과 이미지](https://user-images.githubusercontent.com/22608825/84565590-157dda80-ada5-11ea-97e2-d9053a125348.PNG)


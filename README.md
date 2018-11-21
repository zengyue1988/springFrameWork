jdk 1.8.0_20
maven 3.5.4
# springFrameWork  
    IOC 
    beanwithXMLorAnnotion 
    beanscope 
# springboot   
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-rest-service-0.1.0.jar
# Access data with mySQL
    hibernate ddl auto : none, update, create, create-drop
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-accessing-data-mysql-0.1.0.jar
# Access data with JPA
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-accessing-data-jpa-0.1.0.jar
# Access data with JDBCTemplate
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-relational-data-access-0.1.0.jar

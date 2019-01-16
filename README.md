jdk 1.8.0_20
maven 3.5.4
executable    mvn spring-boot:run
              mvn clean packaage     java -jar target/gs-rest-service-0.1.0.jar
# springFrameWork  
    IOC        
    beanwithXMLorAnnotion 
    beanscope 
        singleton prototype request session application websocket
# springboot   
    @PostMapping @GetMapping @PutMapping @DeleteMapping @RequestMapping
    @RequestParam @PathVariable
# Access data with JPA
    one to one (one way, two way(mappedby))    
    one to many (one way)
    two way find, set null to block cascade     
    two way delete, if CascadeType.REMOVE then remove owning table and inverse table, if CascadeType.ALL then remove inverse table and foreign exchange key from owing table.
# Access data with JDBCTemplate
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-relational-data-access-0.1.0.jar
# Managing transactions
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-managing-transactions-0.1.0.jar
# Cache
    Cacheable, CachePut and CacheEvict. 
    executable    mvn spring-boot:run
                  mvn clean packaage     java -jar target/gs-managing-transactions-0.1.0.jar
# YAML
    server port 8881
# Junit 
    MockMvc
# Java8
    lambda, stream, method reference, functional interface, default method, optional, date, base64
# Spring security
    

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
    @RequestParam @PathVariable @RequestHeader @RequestBody @CookieValue
    @Valid
      @NotBlank @Size @Pattern @NotNull @Min @Max @DecimalMin @DecimalMax @Email @URL @Past @Future @AssertFalse
    swagger : http://localhost:8881/swagger-ui.html#
# Access data with JPA
    ddl-auto: none, update, create, create-drop
    one to one (one way, two way(mappedby))    
    one to many (one way, two way(mappedby))
    many to one (two way(mappedby))
    many to many (two way(mappedby jointable))
    two way find, set null to block cascade or for MVC call, set @JsonIgnoreProperties(value= {"product"}) to avoid overstack    
    two way delete, if CascadeType.REMOVE then remove owning table and inverse table, if CascadeType.ALL then remove inverse table and foreign exchange key from owing table.  CascadeType.REMOVE = CascadeType.ALL + orphanRemoval=true
    Specification
      And Or Like notLike is/equals between lessThan lessThanEqual greaterThan greaterThanEqual after before isNull isNotNull
      startingWith endingWith containing in notIn ignoreCase
    @Query(hql, sql) @Transactional @Modifying 
    @Version
    @Lock   OPTIMISTIC OPTIMISTIC_FORCE_INCREMENT PESSIMITIC_READ PESSIMITIC_WRITE PESSIMITIC_FORCE_INCREMENT NONE
    @Cache  Cacheable, CachePut and CacheEvict. 
    @Transaction   
      readyOnly
      propagation      REQUIRED NOT_SUPPORTED  REQUIRES_NEW  MANDATORY NEVER  SUPPORTS
# Access data with JDBCTemplate
# Junit 
    MockMvc
# Java8
    lambda, stream, method reference, functional interface, default method, optional, date, base64
# Spring security
    build a secure application (/ with method level authorty) 
    inMemoryAuthentication and userDetailsService (password encoder)
    custom login page      /login/form
    custom login           AuthenticationProvider    success and failure handler
    custom role base access control service
    remember me support    data:{username:"Kumar",password:"123456","remember-me": "true"},
    login and logout url
    user attempts and lock
# Spring Batch and scheduler
    reader processor writer listener step
    fixedRate fixedDelay cron
      "0 0 * * * *" = the top of every hour of every day.
      "*/10 * * * * *" = every ten seconds.
      "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
      "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
      "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
      "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
      "0 0 0 25 12 ?" = every Christmas Day at midnight
